package tryToHackServlet;

import java.sql.*;
import java.util.*;
import java.io.*;
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
            String motDePasse = request.getParameter("password");

            System.out.println("Login: session id=" + session.getId());
            
            GestionApplication AppInterrogation = new GestionApplication();
            AppInterrogation.getConnexion().setIsolationReadCommited();
            session.setAttribute("AppInterrogation", AppInterrogation);
            
            GestionApplication AppUpdate = new GestionApplication();
            session.setAttribute("AppUpdate", AppUpdate);
            
            if(username == null && motDePasse == null) {
            		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
                
                return;
            }

            if(request.getParameter("signup") != null) {

	    			System.out.println("--> Switching to sign up form");
	    			
	    			username = "";
	    			motDePasse = "";
	    			
	    			isRegistering = "true";
	    	        request.setAttribute("isRegistering", isRegistering);
	    	        
	    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
	        
			}else if(username != "" && motDePasse != "") {
            		System.out.println("--> Verifying credentials");
            		
        			isRegistering = "false";
        	        request.setAttribute("isRegistering", isRegistering);
            		
            		verifyCredentials(username, motDePasse, request, response);
            		
            		session.setAttribute("etat", new Integer(Constantes.CONNECTE));
            		
            }else if(username == "" || motDePasse == "") {
        		
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
				response.sendRedirect("Accueil?id=" + request.getSession().getId());
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
