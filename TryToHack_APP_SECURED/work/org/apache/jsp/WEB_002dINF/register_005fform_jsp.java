/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.1
 * Generated at: 2018-07-22 00:51:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.*;

public final class register_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>Try to hack</title>\r\n");
      out.write("\t\t<meta HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<style>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t.register_wrapper{\r\n");
      out.write("\t\t\t\tposition:fixed;\r\n");
      out.write("\t\t\t\ttop:20%;\r\n");
      out.write("\t\t\t\tleft:10%;\r\n");
      out.write("\t\t\t\tmargin:0 auto;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_wrapper div{\r\n");
      out.write("\t\t\t\tbackground-color:white;\r\n");
      out.write("\t\t\t\tborder-radius:10px;\r\n");
      out.write("\t\t\t\tpadding:0 25px 10px 25px;\r\n");
      out.write("\t\t\t\twidth:500px;\r\n");
      out.write("\t\t\t\tbox-shadow: 0 0 12px 0 rgba(0,0,0,0.1), 0 10px 30px 0 rgba(0,0,0,0.5);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_wrapper div h2{\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_wrapper div p {\r\n");
      out.write("\t\t\t\tcolor:#6A6D70;\r\n");
      out.write("\t\t\t\tfont-size:12px;\r\n");
      out.write("\t\t\t\tmargin:15px 0 5px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_wrapper div input{\r\n");
      out.write("\t\t\t\twidth:100%;\r\n");
      out.write("\t\t\t\tpadding:10px 10px;\r\n");
      out.write("\t\t\t\tborder:1px solid #BABCBF;\r\n");
      out.write("\t\t\t\tborder-radius:5px;\r\n");
      out.write("\t\t\t\toutline: none;\r\n");
      out.write("\t\t\t\tbackground-color:white;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_wrapper div input:hover, .register_wrapper div input:focus, .register_wrapper div input:active{\r\n");
      out.write("\t\t\t\tborder:1px solid black;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#submit_btn:hover{\r\n");
      out.write("\t\t\t\topacity:0.8;\r\n");
      out.write("\t\t\t\ttext-decoration: underline;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.goBack:hover{\r\n");
      out.write("\t\t\t\ttext-decoration: underline;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"register_wrapper\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<p class=\"goBack\" style=\"display:inline-block; text-align:left; margin:0 0 0 -25px; padding:10px; font-size:12px;\"><a style=\"color:#6A6D70; text-decoration:none;\" href=\"Login\"><i style=\"padding-right:5px;\" class=\"fa fa-arrow-left\"></i>Back</a></p>\r\n");
      out.write("\t\t\t<h2>Sign up</h2>\r\n");
      out.write("\t\t\t<form ACTION=\"Register\" METHOD=\"POST\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<p style=\"width:49%; float:left;\">Nom*</p>\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:right;\">Pr�nom*</p>\r\n");
      out.write("\t\t\t    <input style=\"width:49%; float:left;\" TYPE=\"TEXT\" NAME=\"nom\" autofocus>\r\n");
      out.write("\t\t\t\t<input style=\"width:49%; float:right;\" TYPE=\"TEXT\" NAME=\"prenom\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:left;\">Username*</p>\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:right;\">Email*</p>\r\n");
      out.write("\t\t\t    <input style=\"width:49%; float:left;\" TYPE=\"TEXT\" NAME=\"username\">\r\n");
      out.write("\t\t\t\t<input style=\"width:49%; float:right;\" TYPE=\"TEXT\" NAME=\"email\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:left;\">Password* <span  id=\"label\" style=\"float:right; padding:0 6px; border-radius:3px; color:white;\"></span></p>\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:right;\">Confirm password*</p>\r\n");
      out.write("\t\t\t    <input id=\"txtNewPassword\"  style=\"width:49%; float:left;\" TYPE=\"password\" NAME=\"password\" onkeyup=\"validatePassword(this.value);\"/>\r\n");
      out.write("\t\t\t    <input id=\"txtConfirmPassword\" style=\"width:49%; float:right;\" TYPE=\"password\" NAME=\"password_confirm\" onblur=\"checkPasswordMatch();\"/>\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    <!-- <p style=\"width:49%; float:left;\">Address</p>\r\n");
      out.write("\t\t\t    <p style=\"width:49%; float:right;\">Postal code</p>\r\n");
      out.write("\t\t\t    <input style=\"width:49%; float:left;\" TYPE=\"TEXT\" NAME=\"address\">\r\n");
      out.write("\t\t\t    <input style=\"width:49%; float:right;\" TYPE=\"TEXT\" NAME=\"codepostal\"> -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<input id=\"submit_btn\" type=\"submit\" name=\"signup\" value=\"Sign up\" style=\"background-color:black; color:white; border:0; font-size:14px; margin-top:15px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<p id=\"matchLabel\" style=\"font-size:10px; color:#d9534f;\"></p>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/messageErreur.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!--<p style=\"text-align:center; font-size:10px; margin-top:25px;\"><i class=\"fa fa-lock\"></i><span> Version s�curis�</span></p>\r\n");
      out.write("\t\t\t ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/messageErreur.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t\t");
      out.print( DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CANADA_FRENCH).format(new java.util.Date()) );
      out.write(" -->\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("            function validatePassword(password) {\r\n");
      out.write("                \r\n");
      out.write("                if (password.length === 0) {\r\n");
      out.write("                    document.getElementById(\"label\").innerHTML = \"\";\r\n");
      out.write("                    return;\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                var alphabet = new Array();\r\n");
      out.write("                alphabet.push(\"[A-Z]\"); \r\n");
      out.write("                alphabet.push(\"[a-z]\");   \r\n");
      out.write("                alphabet.push(\"[0-9]\");  \r\n");
      out.write("                alphabet.push(\"[$@$!%*#?&]\"); \r\n");
      out.write("\r\n");
      out.write("                var ctr = 0;\r\n");
      out.write("                for (var i = 0; i < alphabet.length; i++) {\r\n");
      out.write("                    if (new RegExp(alphabet[i]).test(password)) {\r\n");
      out.write("                        ctr++;\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                var color = \"\";\r\n");
      out.write("                var strength = \"\";\r\n");
      out.write("                switch (ctr) {\r\n");
      out.write("                    case 0:\r\n");
      out.write("                    case 1:\r\n");
      out.write("                    case 2:\r\n");
      out.write("                        strength = \"Weak\";\r\n");
      out.write("                        color = \"#d9534f\";\r\n");
      out.write("                        break;\r\n");
      out.write("                    case 3:\r\n");
      out.write("                        strength = \"Medium\";\r\n");
      out.write("                        color = \"#f0ad4e\";\r\n");
      out.write("                        break;\r\n");
      out.write("                    case 4:\r\n");
      out.write("                        strength = \"Strong\";\r\n");
      out.write("                        color = \"#5cb85c\";\r\n");
      out.write("                        break;\r\n");
      out.write("                }\r\n");
      out.write("                document.getElementById(\"label\").innerHTML = strength;\r\n");
      out.write("                document.getElementById(\"label\").style.backgroundColor = color;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            function checkPasswordMatch() {\r\n");
      out.write("                var password = document.getElementById(\"txtNewPassword\").value;\r\n");
      out.write("                var confirmPassword = document.getElementById(\"txtConfirmPassword\").value;\r\n");
      out.write("\r\n");
      out.write("                if (password != confirmPassword)\r\n");
      out.write("                \t\tdocument.getElementById(\"matchLabel\").innerHTML = \"The passwords you entered do not match.\";\r\n");
      out.write("                else\r\n");
      out.write("                \t\tdocument.getElementById(\"matchLabel\").innerHTML = \"\";\r\n");
      out.write("                \t\t\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
