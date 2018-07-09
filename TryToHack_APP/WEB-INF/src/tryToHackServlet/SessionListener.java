package tryToHackServlet;

import javax.servlet.http.*;

import tryToHack.GestionApplication;

import java.sql.*;

public class SessionListener implements HttpSessionListener
{
    public void sessionCreated(HttpSessionEvent se)
    {
    }

    public void sessionDestroyed(HttpSessionEvent se)
    {
        System.out.println("SessionListener " + se.getSession().getId());
        
        GestionApplication interrogation = (GestionApplication)se.getSession().getAttribute("AppInterrogation");
        if (interrogation != null)
        {
            System.out.println("connexion =" + interrogation.getConnexion());
            try
            {
                interrogation.fermer();
            }
            catch (SQLException e)
            {
                System.out.println("Impossible de fermer la connexion");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("Session inaccessible.");
        }
        
        GestionApplication update = (GestionApplication)se.getSession().getAttribute("AppUpdate");
        if (update != null)
        {
            System.out.println("connexion = " + update.getConnexion());
            try
            {
                update.fermer();
            }
            catch (SQLException e)
            {
                System.out.println("Impossible de fermer la connexion");
                e.printStackTrace();
            }
        }
        else
        {
            System.out.println("update inaccessible.");
        }
    }
}
