package tryToHackServlet;

import javax.servlet.*;
import java.util.*;

public class ContextListener implements ServletContextListener
{
    public void contextInitialized(ServletContextEvent sce)
    {
        System.out.println("Contexte démarré : " + sce.getServletContext().getServletContextName());
        
        Enumeration<String> initParams = sce.getServletContext().getInitParameterNames();
        
        while (initParams.hasMoreElements())
        {
            String name = (String) initParams.nextElement();
            System.out.println(name + ":" + sce.getServletContext().getInitParameter(name));
        }
    }

    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("Le contexte de l'application vient d'être détruit.");
    }
}
