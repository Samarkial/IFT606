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
    		
    		if(request.getParameter("signup") != null) {

			String isRegistering = new String();
			isRegistering = "true";
	        request.setAttribute("isRegistering", isRegistering);
	        
	        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
	        
	        return;
		}
    	
		try
        {
            HttpSession session = request.getSession();

            if (session.getAttribute("etat") != null)
            {
                System.out.println("GestionApplication: session déja crée; id=" + session.getId());
                
                session.invalidate();
                session = request.getSession();
                System.out.println("GestionApplication: session invalidée");
            }
            
            String isRegistering = new String();
			isRegistering = "false";
	        request.setAttribute("isRegistering", isRegistering);

            String username = request.getParameter("username");
            String motDePasse = request.getParameter("password");
            String serveur = "localhost"; //request.getParameter("serveur");
            //String bd = request.getParameter("bd");
            
            System.out.println(username);
            System.out.println(motDePasse);

            if (serveur != null)
            {
                System.out.println("Login: session id=" + session.getId());
                
                GestionApplication AppInterrogation = new GestionApplication(username, motDePasse);
                AppInterrogation.getConnexion().setIsolationReadCommited();
                session.setAttribute("AppInterrogation", AppInterrogation);
                
                GestionApplication AppUpdate = new GestionApplication(username, motDePasse);
                session.setAttribute("AppUpdate", AppUpdate);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
                dispatcher.forward(request, response);
                session.setAttribute("etat", new Integer(Constantes.CONNECTE));

            }
        }
        catch (SQLException e)
        {
        		List<String> listeMessageErreur = new LinkedList<String>();
            listeMessageErreur.add("Erreur de connexion au serveur");
            listeMessageErreur.add(e.toString());
            request.setAttribute("listeMessageErreur", listeMessageErreur);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);

            e.printStackTrace();
        }
        catch (TryToHackException e)
        {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
        }
        
    }

    // Dans les formulaires, on utilise la méthode POST
    // donc, si le servlet est appelé avec la méthode GET
    // on appelle POST
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

}
