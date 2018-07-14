package tryToHackServlet;

import java.util.*;
import java.io.*;

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
	        
	        /*GestionApplication AppInterrogation = new GestionApplication();
            AppInterrogation.getConnexion().setIsolationReadCommited();
            session.setAttribute("AppInterrogation", AppInterrogation);
            
            GestionApplication AppUpdate = new GestionApplication();
            session.setAttribute("AppUpdate", AppUpdate);*/
	
	        System.out.println("--> Sign up form");
	      
	        String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	        String username = request.getParameter("username");
	        String motDePasse = request.getParameter("password");
	        String motDePasse2 = request.getParameter("password_confirm");
	        String adresse = request.getParameter("address");
	        String codepostal = request.getParameter("codepostal");
	        
	        if(nom != "" && prenom != "" && username != "" && motDePasse != "" && motDePasse2 != "" ) {
	        		doRegister(nom, prenom, username, motDePasse, motDePasse2, adresse, codepostal, request, response);
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
    
    public void doRegister(String nom, String prenom, String username, String password, String password2, String adresse, String codepostal, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session = request.getSession();

			System.out.println("Nom: " + nom);
	        System.out.println("Prenom: " + prenom);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	        System.out.println("Password confrim: " + password2);
	        System.out.println("Adresse: " + adresse);
	        System.out.println("Code Postal: " + codepostal);
	        
	        if(!password.equals(password2)) {
	        	
		        	String isRegistering = new String();
	    			isRegistering = "true";
	    	        request.setAttribute("isRegistering", isRegistering); 
    	        
	        		System.out.println("Passwords don't match.");
	        		List<String> listeMessageErreur = new LinkedList<String>();
				listeMessageErreur.add("Passwords don't match.");
				request.setAttribute("listeMessageErreur", listeMessageErreur);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				
				return;
	        }

			GestionApplication userToRegister = (GestionApplication) request.getSession().getAttribute("AppUpdate");
			boolean res;
			
			synchronized (userToRegister) {
				res = userToRegister.getGestionUser().addUser(nom, prenom, username, password, password2, adresse, codepostal);
			}
			
			if(res) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
	            dispatcher.forward(request, response);
	            session.setAttribute("etat", new Integer(Constantes.CONNECTE));
			}else {
				throw new TryToHackException("");
			}

		} catch (TryToHackException e) {
			List<String> listeMessageErreur = new LinkedList<String>();
			listeMessageErreur.add("User wasn't insert.");
			request.setAttribute("listeMessageErreur", listeMessageErreur);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
		}
	}

}
