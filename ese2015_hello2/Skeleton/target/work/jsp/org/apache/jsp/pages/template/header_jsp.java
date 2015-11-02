package org.apache.jsp.pages.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      String resourceInjectorClassName = config.getInitParameter("com.sun.appserv.jsp.resource.injector");
      if (resourceInjectorClassName != null) {
        _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) Class.forName(resourceInjectorClassName).newInstance();
        _jspx_resourceInjector.setContext(application);
      }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("<!--\n");
      out.write("\tVerti by HTML5 UP\n");
      out.write("\thtml5up.net | @n33co\n");
      out.write("\tFree for personal and commercial use under the CCA 3.0 license (html5up.net/license)\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>No Sidebar - Verti by HTML5 UP</title>\n");
      out.write("\t\t<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t\t<meta name=\"description\" content=\"\" />\n");
      out.write("\t\t<meta name=\"keywords\" content=\"\" />\n");
      out.write("\t\t<!--[if lte IE 8]><script src=\"/Skeleton/css/ie/html5shiv.js\"></script><![endif]-->\n");
      out.write("\t\t<script src=\"/Skeleton/js/jquery.min.js\"></script>\n");
      out.write("\t\t<script src=\"/Skeleton/js/jquery.dropotron.min.js\"></script>\n");
      out.write("\t\t<script src=\"/Skeleton/js/skel.min.js\"></script>\n");
      out.write("\t\t<script src=\"/Skeleton/js/skel-layers.min.js\"></script>\n");
      out.write("\t\t<script src=\"/Skeleton/js/init.js\"></script>\n");
      out.write("\t\t<noscript>\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"/Skeleton/css/skel.css\" />\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"/Skeleton/css/style.css\" />\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"/Skeleton/css/style-desktop.css\" />\n");
      out.write("\t\t</noscript>\n");
      out.write("\t\t<!--[if lte IE 8]><link rel=\"stylesheet\" href=\"/Skeleton/css/ie/v8.css\" /><![endif]-->\n");
      out.write("\t</head>\n");
      out.write("\t<body class=\"no-sidebar\">\n");
      out.write("\n");
      out.write("\t\t<!-- Header -->\n");
      out.write("\t\t\t<div id=\"header-wrapper\">\n");
      out.write("\t\t\t\t<header id=\"header\" class=\"container\">\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Logo -->\n");
      out.write("\t\t\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t\t\t<h1><a href=\"index.html\">Verti</a></h1>\n");
      out.write("\t\t\t\t\t\t\t<span>by HTML5 UP</span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t<!-- Nav -->\n");
      out.write("\t\t\t\t\t\t<nav id=\"nav\">\n");
      out.write("\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"index.html\">Welcome</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<a href=\"\">Dropdown</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Lorem ipsum dolor</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Magna phasellus</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"\">Phasellus consequat</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Lorem ipsum dolor</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Phasellus consequat</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Magna phasellus</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Etiam dolore nisl</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Veroeros feugiat</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"left-sidebar.html\">Left Sidebar</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"right-sidebar.html\">Right Sidebar</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"current\"><a href=\"no-sidebar.html\">No Sidebar</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</header>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- Main -->\n");
      out.write("\t\t\t<div id=\"main-wrapper\">\n");
      out.write("\t\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t\t<div id=\"content\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<!-- Content -->\n");
      out.write("\t\t\t\t\t\t\t<article>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
