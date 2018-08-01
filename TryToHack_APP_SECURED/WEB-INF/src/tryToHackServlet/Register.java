package tryToHackServlet;

import java.util.*;
import java.io.*;
import java.security.MessageDigest;

import javax.servlet.*;
import javax.servlet.http.*;

import tryToHack.TryToHackException;
import tryToHack.GestionApplication;

public class Register extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	
	    	try {
	        
	    		String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String username = request.getParameter("username");
            String encryptedPassword = null;
            String encryptedPassword2 = null;
            
            System.out.println("Nom: " + nom);
	        System.out.println("Prenom: " + prenom);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + encryptedPassword);
	        System.out.println("Password confrim: " + encryptedPassword2);
            
	        { // Encryption password
	            
	            try {

	                MessageDigest md = MessageDigest.getInstance("MD5");
	                MessageDigest md2 = MessageDigest.getInstance("MD5");
	                
	                md.update(request.getParameter("password").getBytes());
	                md2.update(request.getParameter("password_confirm").getBytes());

	                byte[] bytes = md.digest();
	                byte[] bytes2 = md2.digest();

	                StringBuilder sb = new StringBuilder();
	                for(int i=0; i< bytes.length ;i++)
	                {
	                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	                }
	                StringBuilder sb2 = new StringBuilder();
	                for(int i=0; i< bytes2.length ;i++)
	                {
	                    sb2.append(Integer.toString((bytes2[i] & 0xff) + 0x100, 16).substring(1));
	                }

	                encryptedPassword = sb.toString();
	                encryptedPassword2 = sb2.toString();
	            }
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	            System.out.println("Password encrypted: " + encryptedPassword);
	            System.out.println("Password confirm encrypted: " + encryptedPassword2);
	        }
	        
	        if(nom != "" && prenom != "" && username != "" && encryptedPassword != "" && encryptedPassword2 != "" ) {
	        		doRegister(nom, prenom, username, encryptedPassword, encryptedPassword2, request, response);
	        } else {
	        		throw new TryToHackException("");
	        }
	        
    		}catch (TryToHackException e){
    			List<String> listeMessageErreur = new LinkedList<String>();
    			listeMessageErreur.add("All fields must be filled.");
    			request.setAttribute("listeMessageErreur", listeMessageErreur);
    			
    			String isRegistering = new String();
    			isRegistering = "true";
    	        request.setAttribute("isRegistering", isRegistering);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	        dispatcher.forward(request, response);
	
	        e.printStackTrace();
	    }
		
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
    
    public void doRegister(String nom, String prenom, String username, String password, String password2, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session = request.getSession();
	        
	        if(!password.equals(password2)) {
	        	
		        	String isRegistering = new String();
	    			isRegistering = "true";
	    	        request.setAttribute("isRegistering", isRegistering); 
    	        
	        		List<String> listeMessageErreur = new LinkedList<String>();
				listeMessageErreur.add("The passwords you entered do not match.");
				request.setAttribute("listeMessageErreur", listeMessageErreur);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
				return;
	        }

			GestionApplication userToRegister = (GestionApplication) request.getSession().getAttribute("AppUpdate");
			boolean res;
			
			synchronized (userToRegister) {
				res = userToRegister.getGestionUser().addUser(nom, prenom, username, password, password2);
			}
			
			if(res) {				
				Map<String, List<String>> chat = Accueil.getChatMap();
		        synchronized (chat) {
		            chat.put(username, new ArrayList());
		        }
				
				request.getSession().setAttribute("currentUser", username);
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
				//dispatcher.forward(request, response);
				response.sendRedirect("Accueil");
	            session.setAttribute("etat", new Integer(Constantes.CONNECTE));
			}else {
				throw new TryToHackException("");
			}

		} catch (TryToHackException e) {
			List<String> listeMessageErreur = new LinkedList<String>();
			listeMessageErreur.add("This username is not available.");
			request.setAttribute("listeMessageErreur", listeMessageErreur);
			
			String isRegistering = new String();
			isRegistering = "true";
	        request.setAttribute("isRegistering", isRegistering);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
	}

}
