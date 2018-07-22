<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
  if (request.getAttribute("listeMessageErreur") != null)
    {
%>
    <span style="font-size:10px; color:#d9534f; ">
<%
    ListIterator it = ((List) request.getAttribute("listeMessageErreur")).listIterator();
    while (it.hasNext())
      {
%>
      <%= it.next() %>
<%
      }
%>
    </span>
<%
    }
%>
