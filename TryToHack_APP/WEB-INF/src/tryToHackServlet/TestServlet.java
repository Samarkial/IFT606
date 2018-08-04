/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryToHackServlet;

import com.sun.xml.internal.messaging.saaj.util.Base64;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author denisahmedsamsonabel
 */
public class TestServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    		// Ca c'est appelé quand tu click sur Sign In dans la page testServlet
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/testServlet.jsp");
        dispatcher.forward(request, response);
        
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("This is the Test Servlet");

		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			out.print("<br/>Header Name: <em>" + headerName);
			String headerValue = request.getHeader(headerName);
			out.print("</em>, Header Value: <em>" + headerValue);
			out.println("</em>");
		}

		out.println("<hr/>");
		String authHeader = request.getHeader("authorization");
		String encodedValue = authHeader.split(" ")[1];
		out.println("Base64-encoded Authorization Value: <em>" + encodedValue);
		String decodedValue = Base64.base64Decode(encodedValue);
		out.println("</em><br/>Base64-decoded Authorization Value: <em>" + decodedValue);
		out.println("</em>");
		
	}
}