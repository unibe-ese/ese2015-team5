package org.apache.jsp.pages.template;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\t</article>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<!-- Footer -->\n");
      out.write("\t\t\t<div id=\"footer-wrapper\">\n");
      out.write("\t\t\t\t<footer id=\"footer\" class=\"container\">\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"3u\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!-- Links -->\n");
      out.write("\t\t\t\t\t\t\t\t<section class=\"widget links\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>Random Stuff</h3>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"style2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Etiam feugiat condimentum</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Aliquam imperdiet suscipit odio</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Sed porttitor cras in erat nec</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Felis varius pellentesque potenti</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Nullam scelerisque blandit leo</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"3u\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!-- Links -->\n");
      out.write("\t\t\t\t\t\t\t\t<section class=\"widget links\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>Random Stuff</h3>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"style2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Etiam feugiat condimentum</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Aliquam imperdiet suscipit odio</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Sed porttitor cras in erat nec</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Felis varius pellentesque potenti</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Nullam scelerisque blandit leo</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"3u\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!-- Links -->\n");
      out.write("\t\t\t\t\t\t\t\t<section class=\"widget links\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>Random Stuff</h3>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul class=\"style2\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Etiam feugiat condimentum</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Aliquam imperdiet suscipit odio</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Sed porttitor cras in erat nec</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Felis varius pellentesque potenti</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\">Nullam scelerisque blandit leo</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"3u\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!-- Contact -->\n");
      out.write("\t\t\t\t\t\t\t\t<section class=\"widget contact last\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<h3>Contact Us</h3>\n");
      out.write("\t\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-twitter\"><span class=\"label\">Twitter</span></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-facebook\"><span class=\"label\">Facebook</span></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-instagram\"><span class=\"label\">Instagram</span></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-dribbble\"><span class=\"label\">Dribbble</span></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"icon fa-pinterest\"><span class=\"label\">Pinterest</span></a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t<p>1234 Fictional Road<br />\n");
      out.write("\t\t\t\t\t\t\t\t\tNashville, TN 00000<br />\n");
      out.write("\t\t\t\t\t\t\t\t\t(800) 555-0000</p>\n");
      out.write("\t\t\t\t\t\t\t\t</section>\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"12u\">\n");
      out.write("\t\t\t\t\t\t\t<div id=\"copyright\">\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"menu\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li>&copy; Untitled. All rights reserved</li><li>Design: <a href=\"http://html5up.net\">HTML5 UP</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</footer>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("</html>");
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
