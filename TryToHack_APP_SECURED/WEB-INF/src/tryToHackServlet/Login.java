package tryToHackServlet;

import java.sql.*;
import java.util.*;
import java.io.*;
import java.security.MessageDigest;

import javax.servlet.*;
import javax.servlet.http.*;

import tryToHack.TryToHackException;
import tryToHack.GestionApplication;

public class Login extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		try
        {
            HttpSession session = request.getSession();

            if (session.getAttribute("etat") != null)
            {
                System.out.println("GestionApplication: session déja crée; id=" + session.getId());
                
                session.invalidate();
                session = request.getSession();
            }
            
            String isRegistering = new String();

            String username = request.getParameter("username");
            String encryptedPassword = null;
            
            { // Encryption password
	            
	            try {

	                MessageDigest md = MessageDigest.getInstance("MD5");
	                
	                md.update(request.getParameter("password").getBytes());

	                byte[] bytes = md.digest();

	                StringBuilder sb = new StringBuilder();
	                for(int i=0; i< bytes.length ;i++)
	                {
	                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	                }

	                encryptedPassword = sb.toString();
	            }
	            catch (Exception e)
	            {
	                e.printStackTrace();
	            }
	            System.out.println("Password encrypted: " + encryptedPassword);
	        }

            System.out.println("Login: session id=" + session.getId());
            
            GestionApplication AppInterrogation = new GestionApplication();
            AppInterrogation.getConnexion().setIsolationReadCommited();
            session.setAttribute("AppInterrogation", AppInterrogation);
            
            GestionApplication AppUpdate = new GestionApplication();
            session.setAttribute("AppUpdate", AppUpdate);
            
            if(username == null && encryptedPassword == null) {
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                
                return;
            }

            if(request.getParameter("signup") != null) {

	    			System.out.println("--> Switching to sign up form");
	    			
	    			username = "";
	    			encryptedPassword = "";
	    			
	    			isRegistering = "true";
	    	        request.setAttribute("isRegistering", isRegistering);
	    	        
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
	        
			}else if(username != "" && encryptedPassword != "") {
        			isRegistering = "false";
        	        request.setAttribute("isRegistering", isRegistering);
            		
            		verifyCredentials(username, encryptedPassword, request, response);
            		session.setAttribute("etat", new Integer(Constantes.CONNECTE));
            		
            }else if(username == "" || encryptedPassword == "") {
        		
            		throw new TryToHackException("");
            	
            }else{
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            }

        }
        catch (SQLException e)
        {
        		List<String> listeMessageErreur = new LinkedList<String>();
        		listeMessageErreur.add("Erreur de connexion au serveur.");
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);

        }
        catch (TryToHackException e)
        {
	        	List<String> listeMessageErreur = new LinkedList<String>();
	    		listeMessageErreur.add("Your username or password was entered incorrectly.");
	        request.setAttribute("listeMessageErreur", listeMessageErreur);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	        dispatcher.forward(request, response);
	
        }
        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    public void verifyCredentials(String username, String password, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			System.out.println("Username: " + username);
			System.out.println("Password: " + password);

			GestionApplication userToLogin = (GestionApplication) request.getSession().getAttribute("AppUpdate");
			boolean res;
			
			synchronized (userToLogin) {
				res = userToLogin.getGestionUser().verifyCredentials(username, password);
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
			}else {
				throw new TryToHackException("");
			}

		} catch (TryToHackException e) {
			List<String> listeMessageErreur = new LinkedList<String>();
			listeMessageErreur.add("Your username or password was entered incorrectly.");
			request.setAttribute("listeMessageErreur", listeMessageErreur);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
	}
}
