/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.82
 * Generated at: 2024-04-22 10:17:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Navbar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/D:/Projects/hallodoc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/hallodoc/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("/WEB-INF/lib/spring-webmvc-5.2.4.RELEASE.jar", Long.valueOf(1582650535000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1308849601000L));
    _jspx_dependants.put("jar:file:/D:/Projects/hallodoc/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/hallodoc/WEB-INF/lib/spring-webmvc-5.2.4.RELEASE.jar!/META-INF/spring-form.tld", Long.valueOf(1582628626000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

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
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <title>Admin Dasdhboard New</title>\r\n");
      out.write("\r\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"https://getbootstrap.com/docs/5.3/assets/css/docs.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n");
      out.write("    integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\" crossorigin=\"anonymous\">\r\n");
      out.write(" <link rel=\"stylesheet\"\r\n");
      out.write("	href=\"");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css\">\r\n");
      out.write("  <script src=\"");
      if (_jspx_meth_c_005furl_005f2(_jspx_page_context))
        return;
      out.write("\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  <style>\r\n");
      out.write("    body {\r\n");
      out.write("\r\n");
      out.write("      background-color: white;\r\n");
      out.write("      color: black;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    .dark-mode {\r\n");
      out.write("      background-color: black !important;\r\n");
      out.write("      color: white !important;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .text-dark {\r\n");
      out.write("      color: #f5f0f0 !important;\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <nav class=\"navbar navbar-expand-lg navbar-toggler\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container-fluid flex-column\">\r\n");
      out.write("\r\n");
      out.write("      <ul class=\"navbar-nav w-100 flex-row\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <button class=\"btn btn-outline-info d-lg-none d-inline\" type=\"button\" data-bs-toggle=\"offcanvas\"\r\n");
      out.write("          data-bs-target=\"#offcanvasExample\" aria-controls=\"offcanvasExample\">\r\n");
      out.write("          <img src=\"images/icons8-menu.svg\" alt=\"\">\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"nav-item\">\r\n");
      out.write("          <img class=\"hello-logo1 m-2\" src=\"");
      if (_jspx_meth_c_005furl_005f3(_jspx_page_context))
        return;
      out.write("\" alt=\"\">\r\n");
      out.write("        </li>\r\n");
      out.write("\r\n");
      out.write("        <li class=\"nav-item navbar-right ml-auto\">\r\n");
      out.write("\r\n");
      out.write("          <span class=\"wlcm lo\">Welcome <span style=\"font-weight: 500;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userList[0].firstName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userList[0].lastName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span></span>\r\n");
      out.write("\r\n");
      out.write("          <a type=\"button\" href=\"logout\" class=\"btn btn-outline-info mx-2 lo\">Logout</a>\r\n");
      out.write("\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-outline-info mx-2 lo-btn\">\r\n");
      out.write("            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\"\r\n");
      out.write("              class=\"bi bi-box-arrow-right\" viewBox=\"0 0 16 16\">\r\n");
      out.write("              <path fill-rule=\"evenodd\"\r\n");
      out.write("                d=\"M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0z\" />\r\n");
      out.write("              <path fill-rule=\"evenodd\"\r\n");
      out.write("                d=\"M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708z\" />\r\n");
      out.write("            </svg>\r\n");
      out.write("          </button>\r\n");
      out.write("\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-outline-info px-0 moon-img\" onclick=\"myFunctions()\">\r\n");
      out.write("            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-moon\"\r\n");
      out.write("              viewBox=\"0 0 16 16\">\r\n");
      out.write("              <path\r\n");
      out.write("                d=\"M6 .278a.77.77 0 0 1 .08.858 7.2 7.2 0 0 0-.878 3.46c0 4.021 3.278 7.277 7.318 7.277q.792-.001 1.533-.16a.79.79 0 0 1 .81.316.73.73 0 0 1-.031.893A8.35 8.35 0 0 1 8.344 16C3.734 16 0 12.286 0 7.71 0 4.266 2.114 1.312 5.124.06A.75.75 0 0 1 6 .278M4.858 1.311A7.27 7.27 0 0 0 1.025 7.71c0 4.02 3.279 7.276 7.319 7.276a7.32 7.32 0 0 0 5.205-2.162q-.506.063-1.029.063c-4.61 0-8.343-3.714-8.343-8.29 0-1.167.242-2.278.681-3.286\" />\r\n");
      out.write("            </svg>\r\n");
      out.write("          </button>\r\n");
      out.write("        </li>\r\n");
      out.write("      </ul>\r\n");
      out.write("\r\n");
      out.write("      <!-- <hr class=\"bg-dark\"> -->\r\n");
      out.write("\r\n");
      out.write("      <div class=\"collapse navbar-collapse w-100 d-none d-lg-inline\" id=\"navbarSupportedContent\">\r\n");
      out.write("        <ul class=\"navbar-nav nav-underline\">\r\n");
      out.write("          <li class=\"nav-item mx-2\">\r\n");
      out.write("            <a href=\"dashboard.html\" class=\"nav-link ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${activeString }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">Dashboard</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item mx-2\">\r\n");
      out.write("            <a href=\"provider_location.html\" class=\"nav-link\">Provider Location</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item mx-2\">\r\n");
      out.write("            <a href=\"my_profile.html\" class=\"nav-link\">My Profile</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              providers\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"provider_menu.html\">Provider</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"day_wise_scheduling.html\">Scheduling</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"#\">Invoicing</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item mx-2\">\r\n");
      out.write("            <a href=\"vendor.html\" class=\"nav-link\">Partners</a>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              Access\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"account_access.html\">Account Access</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"user_access.html\">User Access</a></li>\r\n");
      out.write("\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("          <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("            <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("              Records\r\n");
      out.write("            </a>\r\n");
      out.write("            <ul class=\"dropdown-menu\">\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"search_records.html\">Search Records</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"email_logs.html\">Email Logs</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"sms_logs.html\">SMS Logs</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"patient_record.html\">Patient Records</a></li>\r\n");
      out.write("              <li>\r\n");
      out.write("                <hr class=\"dropdown-divider\">\r\n");
      out.write("              </li>\r\n");
      out.write("              <li><a class=\"dropdown-item\" href=\"block_history.html\">Block History</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      <div class=\" offcanvas offcanvas-start d-sm-block d-lg-none bg-white\" tabindex=\"-1\" id=\"offcanvasExample\"\r\n");
      out.write("        aria-labelledby=\"offcanvasExampleLabel\">\r\n");
      out.write("        <div class=\"offcanvas-body\">\r\n");
      out.write("          <span class=\"wlcm lo-btn\">Welcome <span style=\"font-weight: 500;\">Admin admin2</span></span>\r\n");
      out.write("          <ul class=\"navbar-nav nav-underline mt-3\">\r\n");
      out.write("            <li class=\"nav-item mx-2\">\r\n");
      out.write("              <a href=\"dashboard.html\" class=\"nav-link active  text-info\">Dashboard</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item mx-2\">\r\n");
      out.write("              <a href=\"provider_location.html\" class=\"nav-link\">Provider Location</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item mx-2\">\r\n");
      out.write("              <a href=\"my_profile.html\" class=\"nav-link\">My Profile</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\"\r\n");
      out.write("                aria-expanded=\"false\">\r\n");
      out.write("                Providers\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"provider_menu.html\">Provider</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"day_wise_scheduling.html\">Scheduling</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"#\">Invoicing</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item mx-2\">\r\n");
      out.write("              <a href=\"vendor.html\" class=\"nav-link\">Partners</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\"\r\n");
      out.write("                aria-expanded=\"false\">\r\n");
      out.write("                Access\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"account_access.html\">Account Access</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"user_access.html\">User Access</a></li>\r\n");
      out.write("\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown mx-2\">\r\n");
      out.write("              <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\"\r\n");
      out.write("                aria-expanded=\"false\">\r\n");
      out.write("                Records\r\n");
      out.write("              </a>\r\n");
      out.write("              <ul class=\"dropdown-menu\">\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"search_records.html\">Search Records</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"email_logs.html\">Email Logs</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"sms_logs.html\">SMS Logs</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"patient_record.html\">Patient Records</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"block_history.html\">Block History</a></li>\r\n");
      out.write("                <li>\r\n");
      out.write("                  <hr class=\"dropdown-divider\">\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a class=\"dropdown-item\" href=\"patient_history.html\">Block History</a></li>\r\n");
      out.write("\r\n");
      out.write("              </ul>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f0_reused = false;
    try {
      _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f0.setParent(null);
      // /WEB-INF/views/admin/Navbar.jsp(21,7) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f0.setValue("/resources/css/bootstrap.min.css");
      int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
      if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      _jspx_th_c_005furl_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f0, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f1_reused = false;
    try {
      _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f1.setParent(null);
      // /WEB-INF/views/admin/Navbar.jsp(22,29) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f1.setValue("/resources/css/style.css");
      int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
      if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      _jspx_th_c_005furl_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f1, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f1_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f2(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f2 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f2_reused = false;
    try {
      _jspx_th_c_005furl_005f2.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f2.setParent(null);
      // /WEB-INF/views/admin/Navbar.jsp(24,15) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f2.setValue("/resources/js/script.js");
      int _jspx_eval_c_005furl_005f2 = _jspx_th_c_005furl_005f2.doStartTag();
      if (_jspx_th_c_005furl_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f2);
      _jspx_th_c_005furl_005f2_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f2, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f2_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f3(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f3 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    boolean _jspx_th_c_005furl_005f3_reused = false;
    try {
      _jspx_th_c_005furl_005f3.setPageContext(_jspx_page_context);
      _jspx_th_c_005furl_005f3.setParent(null);
      // /WEB-INF/views/admin/Navbar.jsp(63,44) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005furl_005f3.setValue("/resources/images/hellodoc-logo.png");
      int _jspx_eval_c_005furl_005f3 = _jspx_th_c_005furl_005f3.doStartTag();
      if (_jspx_th_c_005furl_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f3);
      _jspx_th_c_005furl_005f3_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005furl_005f3, _jsp_getInstanceManager(), _jspx_th_c_005furl_005f3_reused);
    }
    return false;
  }
}