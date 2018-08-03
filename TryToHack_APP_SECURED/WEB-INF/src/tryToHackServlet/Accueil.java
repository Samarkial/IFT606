package tryToHackServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

public class Accueil extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // verification de l'�tat de la session
        HttpSession session = request.getSession();
        Integer etat = (Integer) session.getAttribute("etat");
        if (etat == null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }
        else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/accueil.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    // message map, mapping user UID with a message list
 	private static Map<String, List<String>> _chat = new HashMap<String, List<String>>();
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    	request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		// send message
		if ("send".equals(action)) {
			// get param with UTF-8 enconding
			String msg = new String(request.getParameter("msg").getBytes("ISO-8859-1"), "UTF-8");
			String user = (String) request.getSession().getAttribute("currentUser");
			for (String s : _chat.keySet()) {
				if (!s.equals(user)) {
					synchronized (_chat.get(s)) {
						// put message to any other user's msg list
						_chat.get(s).add(user + " said: " + msg);
					}
				}
			}
		} else if ("get".equals(action)) { // get message
			String user = (String) request.getSession().getAttribute("currentUser");
			if (user == null)
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			else {
				List<String> l = _chat.get(user);

				synchronized (l) {
					if (l.size() > 0) {
						// for UTF-8 chars
						response.setCharacterEncoding("UTF-8");
						PrintWriter out = response.getWriter();
						JSONArray jsna = new JSONArray();
						// add all msg to json array and clear list
						while (l.size() > 0)
							jsna.add(l.remove(0));
						out.println(jsna);
						out.close();
					}
				}
			}

			else if ("email".equals(action)){
				System.out.println(action);
				String user = (String) request.getSession().getAttribute("currentUser");
				if (user == null)
					response.sendError(HttpServletResponse.SC_BAD_REQUEST);
				else {
					String sender = new String(request.getParameter("sender").getBytes("ISO-8859-1"), "UTF-8");
					String senderPSW = new String(request.getParameter("senderPSW").getBytes("ISO-8859-1"), "UTF-8");
					String receiver = new String(request.getParameter("receiver").getBytes("ISO-8859-1"), "UTF-8");
					String subject = new String(request.getParameter("subject").getBytes("ISO-8859-1"), "UTF-8");
					String message = new String(request.getParameter("message").getBytes("ISO-8859-1"), "UTF-8");
					System.out.println(sender + receiver + subject + message);
					try {
						Email email = new SimpleEmail();
						email.setHostName("smtp.gmail.com");
						email.setSmtpPort(465);
						email.setAuthenticator(new DefaultAuthenticator(sender, senderPSW));
						email.setSSLOnConnect(true);
						email.setFrom(sender);
						email.setSubject(subject);
						email.setMsg(message);
						email.addTo(receiver);
						email.send();
					}catch(Exception ex){
						System.out.println("Unable to send email");
						System.out.println(ex);
					}
				}
			}
		}
    }
    
    public static Map<String, List<String>> getChatMap() {
		return _chat;
	}
}
