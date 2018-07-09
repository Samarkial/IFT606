<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%
  if (request.getAttribute("listeMessageErreur") != null)
    {
%>
    <span style="font-size:10px; color:#FF2D55; ">
<%
    ListIterator it = ((List) request.getAttribute("listeMessageErreur")).listIterator();
    while (it.hasNext())
      {
%>
      <BR>
      <BR>
      <BR>
      <%= it.next() %>
<%
      }
%>
    </span>
<%
    }
%>
