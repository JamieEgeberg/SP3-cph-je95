package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Result Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"col-sm-9\">\n");
      out.write("            <h3> Welcome ");
      out.print( request.getAttribute("username"));
      out.write(" </h3>\n");
      out.write("\n");
      out.write("            Your current balance : ");
      out.print( request.getAttribute("balance"));
      out.write("\n");
      out.write("\n");
      out.write("            <br>\n");
      out.write("            To buy, please choose desired combination and press button to add to cart.\n");
      out.write("            <form id=\"Form\" action=\"Buy\" method=\"POST\">\n");
      out.write("                <h5>Choose cake bottom:</h5>\n");
      out.write("                <input type=\"radio\" name=\"Bottom\" value=\"Chocolate\" />Chocolate<br>\n");
      out.write("                <input type=\"radio\" name=\"Bottom\" value=\"Vanilla\" />Vanilla<br>\n");
      out.write("                <input type=\"radio\" name=\"Bottom\" value=\"Nutmeg\" />Nutmeg<br>\n");
      out.write("                <input type=\"radio\" name=\"Bottom\" value=\"Pistacio\" />Pistachio<br>\n");
      out.write("                <input type=\"radio\" name=\"Bottom\" value=\"Almond\" />Almond<br>\n");
      out.write("\n");
      out.write("                <h5>Choose frosting topping:</h5>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Chocolate\" />Chocolate<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Blueberry\" />Blueberry<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Raspberry\" />Raspberry<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Crispy\" />Crispy<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Strawberry\" />Strawberry<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Rum/raisin\" />Rum/raisin<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Orange\" />Orange<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Lemon\" />Lemon<br>\n");
      out.write("                <input type=\"radio\" name=\"Top\" value=\"Blue cheese\" />Blue cheese<br>\n");
      out.write("                <br>\n");
      out.write("                Amount: <input type=\"number\" name=\"quantity\" min=\"1\" max=\"99\"><br>\n");
      out.write("                <br>\n");
      out.write("                <input type=\"submit\" value=\"Add\" />\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-3\">\n");
      out.write("            Cart<table border=\"0\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Topping</th>\n");
      out.write("                        <th>Bottom</th>\n");
      out.write("                        <th>Amount</th>\n");
      out.write("                        <th>Total</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                        <td></td>\n");
      out.write("                    </tr>\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <script src=\"script/script.js\" type=\"text/javascript\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
