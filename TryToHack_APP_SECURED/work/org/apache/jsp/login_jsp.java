/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.1
 * Generated at: 2018-08-04 18:44:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\t<style>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\tbody{\r\n");
      out.write("\t\t\t\tbackground-image:url(background.jpg);\r\n");
      out.write("\t\t\t\tbackground-size:cover;\r\n");
      out.write("\t\t\t\tbackground-repeat:no-repeat;\r\n");
      out.write("\t\t\t\tbackground-position: top center ;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\th1{\r\n");
      out.write("\t\t\t\tcolor:white;\r\n");
      out.write("\t\t\t\tfont-weight:400;\r\n");
      out.write("\t\t\t\tmargin-left:5px;\r\n");
      out.write("\t\t\t\ttext-shadow: 0 1px 4px rgba(0,0,0,1);\r\n");
      out.write("\t\t\t\tfont-size:22px;\r\n");
      out.write("\t\t\t\tdisplay:inline;\r\n");
      out.write("\t\t\t\tmargin:0 auto;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t.login_wrapper{\r\n");
      out.write("\t\t\t\tposition:fixed;\r\n");
      out.write("\t\t\t\ttop:20%;\r\n");
      out.write("\t\t\t\tleft:10%;\r\n");
      out.write("\t\t\t\tmargin:0 auto;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_btn{\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.register_btn a{\r\n");
      out.write("\t\t\t\tcolor:rgb(63, 159, 255);\r\n");
      out.write("\t\t\t\ttext-decoration:none;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.login_wrapper div{\r\n");
      out.write("\t\t\t\tbackground-color:white;\r\n");
      out.write("\t\t\t\tbox-shadow: 0 0 12px 0 rgba(0,0,0,0.1), 0 10px 30px 0 rgba(0,0,0,0.5);\r\n");
      out.write("\t\t\t\tborder-radius:10px;\r\n");
      out.write("\t\t\t\tpadding:25px;\r\n");
      out.write("\t\t\t\twidth:225px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.login_wrapper div h2{\r\n");
      out.write("\t\t\t\ttext-align:center;\r\n");
      out.write("\t\t\t\tpadding-bottom:15px;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.login_wrapper div p {\r\n");
      out.write("\t\t\t\tcolor:#6A6D70;\r\n");
      out.write("\t\t\t\tfont-size:12px;\r\n");
      out.write("\t\t\t\tmargin:15px 0 5px 0;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.login_wrapper div input{\r\n");
      out.write("\t\t\t\twidth:100%;\r\n");
      out.write("\t\t\t\tpadding:10px 10px;\r\n");
      out.write("\t\t\t\tborder:1px solid #BABCBF;\r\n");
      out.write("\t\t\t\tborder-radius:5px;\r\n");
      out.write("\t\t\t\toutline: none;\r\n");
      out.write("\t\t\t\tbackground-color:white;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.login_wrapper div input:hover, .login_wrapper div input:focus, .login_wrapper div input:active{\r\n");
      out.write("\t\t\t\tborder:1px solid black;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t#submit_btn:hover{\r\n");
      out.write("\t\t\t\topacity:0.8;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.copyright{\r\n");
      out.write("\t\t\t\tposition:fixed;\r\n");
      out.write("\t\t\t\tright:0;\r\n");
      out.write("\t\t\t\tleft:0;\r\n");
      out.write("\t\t\t\tbottom:20px;\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t.copyright p {\r\n");
      out.write("\t\t\t\tcolor: white ; //#6A6D70;\r\n");
      out.write("\t\t\t\ttext-align:right;\r\n");
      out.write("\t\t\t\tfont-size:12px;\r\n");
      out.write("\t\t\t\tmargin:15px 25px 5px 0;\r\n");
      out.write("\t\t\t\ttext-shadow: 0 1px 4px rgba(0,0,0,0.5);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<!-- <div class=\"navigation_wrapper\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"Logout\">D�connexion</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"Accueil\">Accueil</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div> -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h1 style=\"position:fixed; left:15px; background-color:black; padding:2px 5px;\">Try to hack</h1>\r\n");
      out.write("\t\t<h1 style=\"text-align:center; position:fixed; left:0; right:0; top:15px; font-size:16px;\"><i class=\"fa fa-lock\"></i><span> Version s�curis�</span></h1>\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t");

  			if (request.getAttribute("isRegistering") == "true"){
		
      out.write("\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/register_form.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t");

  			}else{
		
      out.write("\r\n");
      out.write("\t\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/login_form.jsp", out, false);
      out.write("\r\n");
      out.write("\t\t");

  			}
		
      out.write("\r\n");
      out.write("\t\t<div class=\"copyright\">\r\n");
      out.write("\t\t\t<p>�2018 IFT606 - S�curit� & Cryptography. Projet de session.</p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</body>\r\n");
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
