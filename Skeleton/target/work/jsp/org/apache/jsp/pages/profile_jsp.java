package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class profile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_import_url_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_style_modelAttribute_method_id_cssClass_autocomplete_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_checkbox_tabindex_path_id_element_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_errors_path_element_cssClass_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_errors_path_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_input_value_type_style_placeholder_path_name_maxlength_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_method_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_form_modelAttribute_method_id_disabled_action;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_form_input_path_nobody;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_import_url_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_style_modelAttribute_method_id_cssClass_autocomplete_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_checkbox_tabindex_path_id_element_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_errors_path_element_cssClass_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_errors_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_input_value_type_style_placeholder_path_name_maxlength_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_method_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_form_modelAttribute_method_id_disabled_action = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_form_input_path_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_import_url_nobody.release();
    _jspx_tagPool_form_form_style_modelAttribute_method_id_cssClass_autocomplete_action.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_form_checkbox_tabindex_path_id_element_nobody.release();
    _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody.release();
    _jspx_tagPool_form_errors_path_element_cssClass_nobody.release();
    _jspx_tagPool_c_set_var.release();
    _jspx_tagPool_form_errors_path_nobody.release();
    _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody.release();
    _jspx_tagPool_form_input_value_type_style_placeholder_path_name_maxlength_nobody.release();
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_form_form_method_action.release();
    _jspx_tagPool_form_form_modelAttribute_method_id_disabled_action.release();
    _jspx_tagPool_form_input_path_nobody.release();
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
      response.setContentType("text/html;charset=utf-8");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_import_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  form:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_0 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_style_modelAttribute_method_id_cssClass_autocomplete_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_form_form_0.setPageContext(_jspx_page_context);
      _jspx_th_form_form_0.setParent(null);
      _jspx_th_form_form_0.setMethod("post");
      _jspx_th_form_form_0.setModelAttribute("modifyUserForm");
      _jspx_th_form_form_0.setAction("./modifyUser");
      _jspx_th_form_form_0.setId("modifyUserForm");
      _jspx_th_form_form_0.setCssClass("form-horizontal");
      _jspx_th_form_form_0.setAutocomplete("off");
      _jspx_th_form_form_0.setDynamicAttribute(null, "style", new String("width:500px"));
      int[] _jspx_push_body_count_form_form_0 = new int[] { 0 };
      try {
        int _jspx_eval_form_form_0 = _jspx_th_form_form_0.doStartTag();
        if (_jspx_eval_form_form_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("    <fieldset>\r\n");
            out.write("        <legend><h1>Edit your information</h1></legend>\r\n");
            out.write("        ");
            if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("\r\n");
            out.write("        <div>\r\n");
            out.write("            <label class=\"control-label\" >Email</label>\r\n");
            out.write("                <div class=\"controls\">\r\n");
            out.write("                  ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\r\n");
            out.write("                </div>\r\n");
            out.write("        </div>\r\n");
            out.write("        <div class=\"control-group\">\r\n");
            out.write("            <label class=\"control-label\" for=\"field-firstName\">Enable Tutor</label>\r\n");
            out.write("            <div class=\"controls\">\r\n");
            out.write("                ");
            if (_jspx_meth_form_checkbox_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("        <div class=\"control-group\">\r\n");
            out.write("            <label class=\"control-label\" for=\"field-firstName\">First Name</label>\r\n");
            out.write("            <div class=\"controls\">\r\n");
            out.write("                ");
            if (_jspx_meth_form_input_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("                ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_0 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_0.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_form_errors_0.setPath("firstName");
            _jspx_th_form_errors_0.setCssClass("help-inline");
            _jspx_th_form_errors_0.setElement("span");
            int[] _jspx_push_body_count_form_errors_0 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_0 = _jspx_th_form_errors_0.doStartTag();
              if (_jspx_th_form_errors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_0[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_0.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_0.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_0);
            }
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("        ");
            //  c:set
            org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
            _jspx_th_c_set_0.setPageContext(_jspx_page_context);
            _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_c_set_0.setVar("lastNameErrors");
            int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
            if (_jspx_eval_c_set_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_c_set_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_push_body_count_form_form_0[0]++;
                _jspx_th_c_set_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_c_set_0.doInitBody();
              }
              do {
                //  form:errors
                org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_1 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
                _jspx_th_form_errors_1.setPageContext(_jspx_page_context);
                _jspx_th_form_errors_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_set_0);
                _jspx_th_form_errors_1.setPath("lastName");
                int[] _jspx_push_body_count_form_errors_1 = new int[] { 0 };
                try {
                  int _jspx_eval_form_errors_1 = _jspx_th_form_errors_1.doStartTag();
                  if (_jspx_th_form_errors_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    return;
                  }
                } catch (Throwable _jspx_exception) {
                  while (_jspx_push_body_count_form_errors_1[0]-- > 0)
                    out = _jspx_page_context.popBody();
                  _jspx_th_form_errors_1.doCatch(_jspx_exception);
                } finally {
                  _jspx_th_form_errors_1.doFinally();
                  _jspx_tagPool_form_errors_path_nobody.reuse(_jspx_th_form_errors_1);
                }
                int evalDoAfterBody = _jspx_th_c_set_0.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_c_set_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
                _jspx_push_body_count_form_form_0[0]--;
            }
            if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_0);
              return;
            }
            _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_0);
            out.write("\r\n");
            out.write("        <div class=\"control-group");
            if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\">\r\n");
            out.write("            <label class=\"control-label\" for=\"field-lastName\">Last Name</label>\r\n");
            out.write("            <div class=\"controls\">\r\n");
            out.write("                ");
            if (_jspx_meth_form_input_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("                ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_2 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_2.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_form_errors_2.setPath("lastName");
            _jspx_th_form_errors_2.setCssClass("help-inline");
            _jspx_th_form_errors_2.setElement("span");
            int[] _jspx_push_body_count_form_errors_2 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_2 = _jspx_th_form_errors_2.doStartTag();
              if (_jspx_th_form_errors_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_2[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_2.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_2.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_2);
            }
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("        ");
            //  c:set
            org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
            _jspx_th_c_set_1.setPageContext(_jspx_page_context);
            _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_c_set_1.setVar("passwordErrors");
            int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
            if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_push_body_count_form_form_0[0]++;
                _jspx_th_c_set_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_c_set_1.doInitBody();
              }
              do {
                //  form:errors
                org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_3 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
                _jspx_th_form_errors_3.setPageContext(_jspx_page_context);
                _jspx_th_form_errors_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_set_1);
                _jspx_th_form_errors_3.setPath("password");
                int[] _jspx_push_body_count_form_errors_3 = new int[] { 0 };
                try {
                  int _jspx_eval_form_errors_3 = _jspx_th_form_errors_3.doStartTag();
                  if (_jspx_th_form_errors_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    return;
                  }
                } catch (Throwable _jspx_exception) {
                  while (_jspx_push_body_count_form_errors_3[0]-- > 0)
                    out = _jspx_page_context.popBody();
                  _jspx_th_form_errors_3.doCatch(_jspx_exception);
                } finally {
                  _jspx_th_form_errors_3.doFinally();
                  _jspx_tagPool_form_errors_path_nobody.reuse(_jspx_th_form_errors_3);
                }
                int evalDoAfterBody = _jspx_th_c_set_1.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_c_set_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
                _jspx_push_body_count_form_form_0[0]--;
            }
            if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_1);
              return;
            }
            _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_1);
            out.write("\r\n");
            out.write("        <div class=\"control-group");
            if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\">\r\n");
            out.write("            <label class=\"control-label\" for=\"field-password\">Password</label>\r\n");
            out.write("            <div class=\"controls\">\r\n");
            out.write("                ");
            if (_jspx_meth_form_input_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("                ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_4 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_4.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_form_errors_4.setPath("password");
            _jspx_th_form_errors_4.setCssClass("help-inline");
            _jspx_th_form_errors_4.setElement("span");
            int[] _jspx_push_body_count_form_errors_4 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_4 = _jspx_th_form_errors_4.doStartTag();
              if (_jspx_th_form_errors_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_4[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_4.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_4.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_4);
            }
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("        </div>\r\n");
            out.write("        ");
            //  c:set
            org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
            _jspx_th_c_set_2.setPageContext(_jspx_page_context);
            _jspx_th_c_set_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_c_set_2.setVar("passwordErrors");
            int _jspx_eval_c_set_2 = _jspx_th_c_set_2.doStartTag();
            if (_jspx_eval_c_set_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
              if (_jspx_eval_c_set_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                out = _jspx_page_context.pushBody();
                _jspx_push_body_count_form_form_0[0]++;
                _jspx_th_c_set_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                _jspx_th_c_set_2.doInitBody();
              }
              do {
                //  form:errors
                org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_5 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
                _jspx_th_form_errors_5.setPageContext(_jspx_page_context);
                _jspx_th_form_errors_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_set_2);
                _jspx_th_form_errors_5.setPath("passwordControll");
                int[] _jspx_push_body_count_form_errors_5 = new int[] { 0 };
                try {
                  int _jspx_eval_form_errors_5 = _jspx_th_form_errors_5.doStartTag();
                  if (_jspx_th_form_errors_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    return;
                  }
                } catch (Throwable _jspx_exception) {
                  while (_jspx_push_body_count_form_errors_5[0]-- > 0)
                    out = _jspx_page_context.popBody();
                  _jspx_th_form_errors_5.doCatch(_jspx_exception);
                } finally {
                  _jspx_th_form_errors_5.doFinally();
                  _jspx_tagPool_form_errors_path_nobody.reuse(_jspx_th_form_errors_5);
                }
                int evalDoAfterBody = _jspx_th_c_set_2.doAfterBody();
                if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                  break;
              } while (true);
              if (_jspx_eval_c_set_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                out = _jspx_page_context.popBody();
                _jspx_push_body_count_form_form_0[0]--;
            }
            if (_jspx_th_c_set_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
              _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_2);
              return;
            }
            _jspx_tagPool_c_set_var.reuse(_jspx_th_c_set_2);
            out.write("\r\n");
            out.write("        <div class=\"control-group");
            if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\">\r\n");
            out.write("            <label class=\"control-label\" for=\"field-password\">Again Please</label>\r\n");
            out.write("            <div class=\"controls\">\r\n");
            out.write("                ");
            if (_jspx_meth_form_input_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
            out.write("\r\n");
            out.write("                ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_6 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_6.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
            _jspx_th_form_errors_6.setPath("password");
            _jspx_th_form_errors_6.setCssClass("help-inline");
            _jspx_th_form_errors_6.setElement("span");
            int[] _jspx_push_body_count_form_errors_6 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_6 = _jspx_th_form_errors_6.doStartTag();
              if (_jspx_th_form_errors_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_6[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_6.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_6.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_6);
            }
            out.write("\r\n");
            out.write("            </div>\r\n");
            out.write("\t\t \t<div>\r\n");
            out.write("         \t\t");
            if (_jspx_meth_form_input_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_0, _jspx_page_context, _jspx_push_body_count_form_form_0))
              return;
<<<<<<< HEAD
            out.write("\r\n");
            out.write("        \t</div>\r\n");
            out.write("        </div>\r\n");
            out.write("        <div class=\"form-actions\">\r\n");
            out.write("            <input type=\"submit\" value=\"Edit\" class=\"btn btn-primary\"></input>\r\n");
            out.write("        </div>\r\n");
            out.write("    </fieldset>\r\n");
=======
            out.write("\n");
            out.write("        \t</div>\n");
            out.write("        </div>\n");
            out.write("        <div class=\"form-actions\">\n");
            out.write("            <input type=\"submit\" value=\"Edit\" class=\"btn btn-primary\"></input>\n");
            out.write("        </div>\n");
            out.write("    </fieldset>\n");
>>>>>>> origin/master
            int evalDoAfterBody = _jspx_th_form_form_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_form_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_form_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_form_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_form_0.doFinally();
        _jspx_tagPool_form_form_style_modelAttribute_method_id_cssClass_autocomplete_action.reuse(_jspx_th_form_form_0);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table>\r\n");
      out.write("    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</table>\r\n");
      //  form:form
      org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_2 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_modelAttribute_method_id_disabled_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
      _jspx_th_form_form_2.setPageContext(_jspx_page_context);
      _jspx_th_form_form_2.setParent(null);
      _jspx_th_form_form_2.setMethod("post");
      _jspx_th_form_form_2.setModelAttribute("addCompetenceForm");
      _jspx_th_form_form_2.setAction("./addCompetence");
      _jspx_th_form_form_2.setId("addComp");
      _jspx_th_form_form_2.setDynamicAttribute(null, "disabled", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!user.enableTutor}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_form_form_2 = new int[] { 0 };
      try {
        int _jspx_eval_form_form_2 = _jspx_th_form_form_2.doStartTag();
        if (_jspx_eval_form_form_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("    <div>\r\n");
            out.write("      ");
            if (_jspx_meth_form_input_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_form_form_2, _jspx_page_context, _jspx_push_body_count_form_form_2))
              return;
            out.write("\r\n");
            out.write("      ");
            //  form:errors
            org.springframework.web.servlet.tags.form.ErrorsTag _jspx_th_form_errors_7 = (org.springframework.web.servlet.tags.form.ErrorsTag) _jspx_tagPool_form_errors_path_element_cssClass_nobody.get(org.springframework.web.servlet.tags.form.ErrorsTag.class);
            _jspx_th_form_errors_7.setPageContext(_jspx_page_context);
            _jspx_th_form_errors_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_2);
            _jspx_th_form_errors_7.setPath("description");
            _jspx_th_form_errors_7.setCssClass("help-inline");
            _jspx_th_form_errors_7.setElement("span");
            int[] _jspx_push_body_count_form_errors_7 = new int[] { 0 };
            try {
              int _jspx_eval_form_errors_7 = _jspx_th_form_errors_7.doStartTag();
              if (_jspx_th_form_errors_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                return;
              }
            } catch (Throwable _jspx_exception) {
              while (_jspx_push_body_count_form_errors_7[0]-- > 0)
                out = _jspx_page_context.popBody();
              _jspx_th_form_errors_7.doCatch(_jspx_exception);
            } finally {
              _jspx_th_form_errors_7.doFinally();
              _jspx_tagPool_form_errors_path_element_cssClass_nobody.reuse(_jspx_th_form_errors_7);
            }
            out.write("\r\n");
            out.write("    </div>\r\n");
            out.write("    <input type=\"submit\" value=\"Add\"></input>\r\n");
            int evalDoAfterBody = _jspx_th_form_form_2.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_form_form_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_form_form_2[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_form_form_2.doCatch(_jspx_exception);
      } finally {
        _jspx_th_form_form_2.doFinally();
        _jspx_tagPool_form_form_modelAttribute_method_id_disabled_action.reuse(_jspx_th_form_form_2);
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("<img src=\"/Skeleton/imageDisplay$userId=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" style=\"height:100px; width:100px\"/>\r\n");
      out.write("<form method=\"POST\" action=\"./changeProfilePic\" enctype=\"multipart/form-data\">\r\n");
      out.write("         File to upload: <input type=\"file\" name=\"file\" >\r\n");
      out.write("       <input type=\"submit\" value=\"Upload\"> Press here to upload the file!\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_import_1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
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

  private boolean _jspx_meth_c_import_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_0.setPageContext(_jspx_page_context);
    _jspx_th_c_import_0.setParent(null);
    _jspx_th_c_import_0.setUrl("template/header.jsp");
    int[] _jspx_push_body_count_c_import_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_0 = _jspx_th_c_import_0.doStartTag();
      if (_jspx_th_c_import_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_0.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty error}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("           Error: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_form_checkbox_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:checkbox
    org.springframework.web.servlet.tags.form.CheckboxTag _jspx_th_form_checkbox_0 = (org.springframework.web.servlet.tags.form.CheckboxTag) _jspx_tagPool_form_checkbox_tabindex_path_id_element_nobody.get(org.springframework.web.servlet.tags.form.CheckboxTag.class);
    _jspx_th_form_checkbox_0.setPageContext(_jspx_page_context);
    _jspx_th_form_checkbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_checkbox_0.setPath("enableTutor");
    _jspx_th_form_checkbox_0.setId("field-enableTut");
    _jspx_th_form_checkbox_0.setTabindex("1");
    _jspx_th_form_checkbox_0.setDynamicAttribute(null, "element", new String("span"));
    int[] _jspx_push_body_count_form_checkbox_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_checkbox_0 = _jspx_th_form_checkbox_0.doStartTag();
      if (_jspx_th_form_checkbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_checkbox_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_checkbox_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_checkbox_0.doFinally();
      _jspx_tagPool_form_checkbox_tabindex_path_id_element_nobody.reuse(_jspx_th_form_checkbox_0);
    }
    return false;
  }

  private boolean _jspx_meth_form_input_0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_0 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_0.setPageContext(_jspx_page_context);
    _jspx_th_form_input_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_0.setPath("firstName");
    _jspx_th_form_input_0.setId("field-firstName");
    _jspx_th_form_input_0.setTabindex("2");
    _jspx_th_form_input_0.setMaxlength("35");
    _jspx_th_form_input_0.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.firstName}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_form_input_0 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_0 = _jspx_th_form_input_0.doStartTag();
      if (_jspx_th_form_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_0.doFinally();
      _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody.reuse(_jspx_th_form_input_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty lastNameErrors}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" error");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_form_input_1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_1 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_1.setPageContext(_jspx_page_context);
    _jspx_th_form_input_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_1.setPath("lastName");
    _jspx_th_form_input_1.setId("field-lastName");
    _jspx_th_form_input_1.setTabindex("3");
    _jspx_th_form_input_1.setMaxlength("35");
    _jspx_th_form_input_1.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.lastName}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_form_input_1 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_1 = _jspx_th_form_input_1.doStartTag();
      if (_jspx_th_form_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_1.doFinally();
      _jspx_tagPool_form_input_value_tabindex_path_maxlength_id_nobody.reuse(_jspx_th_form_input_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty password}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" error");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_form_input_2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_2 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_2.setPageContext(_jspx_page_context);
    _jspx_th_form_input_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_2.setPath("password");
    _jspx_th_form_input_2.setDynamicAttribute(null, "type", new String("password"));
    _jspx_th_form_input_2.setId("field-password");
    _jspx_th_form_input_2.setTabindex("3");
    _jspx_th_form_input_2.setMaxlength("35");
    _jspx_th_form_input_2.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_form_input_2 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_2 = _jspx_th_form_input_2.doStartTag();
      if (_jspx_th_form_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_2.doFinally();
      _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody.reuse(_jspx_th_form_input_2);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty password}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" error");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_form_input_3(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_3 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_3.setPageContext(_jspx_page_context);
    _jspx_th_form_input_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_3.setPath("passwordControll");
    _jspx_th_form_input_3.setDynamicAttribute(null, "type", new String("password"));
    _jspx_th_form_input_3.setId("field-password");
    _jspx_th_form_input_3.setTabindex("4");
    _jspx_th_form_input_3.setMaxlength("35");
    _jspx_th_form_input_3.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_form_input_3 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_3 = _jspx_th_form_input_3.doStartTag();
      if (_jspx_th_form_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_3.doFinally();
      _jspx_tagPool_form_input_value_type_tabindex_path_maxlength_id_nobody.reuse(_jspx_th_form_input_3);
    }
    return false;
  }

  private boolean _jspx_meth_form_input_4(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_4 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_value_type_style_placeholder_path_name_maxlength_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_4.setPageContext(_jspx_page_context);
    _jspx_th_form_input_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_0);
    _jspx_th_form_input_4.setDynamicAttribute(null, "type", new String("textarea"));
    _jspx_th_form_input_4.setPath("aboutYou");
    _jspx_th_form_input_4.setDynamicAttribute(null, "value", (java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.aboutYou}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_form_input_4.setDynamicAttribute(null, "style", new String("height: 400px; margin: 20px 0px 50px;"));
    _jspx_th_form_input_4.setDynamicAttribute(null, "name", new String("Tutor Description"));
    _jspx_th_form_input_4.setMaxlength("500");
    _jspx_th_form_input_4.setDynamicAttribute(null, "placeholder", new String("Personal Description"));
    int[] _jspx_push_body_count_form_input_4 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_4 = _jspx_th_form_input_4.doStartTag();
      if (_jspx_th_form_input_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_4[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_4.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_4.doFinally();
      _jspx_tagPool_form_input_value_type_style_placeholder_path_name_maxlength_nobody.reuse(_jspx_th_form_input_4);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.competences}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("competence");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("        <tr>\r\n");
          out.write("            <td>\r\n");
          out.write("                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${competence.description}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\r\n");
          out.write("            </td>\r\n");
          out.write("            <td>\r\n");
          out.write("                ");
          if (_jspx_meth_form_form_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\r\n");
          out.write("            </td>\r\n");
          out.write("\r\n");
          out.write("        </tr>\r\n");
          out.write("    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_form_form_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_form_1 = (org.springframework.web.servlet.tags.form.FormTag) _jspx_tagPool_form_form_method_action.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_form_1.setPageContext(_jspx_page_context);
    _jspx_th_form_form_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_form_form_1.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("profile/delete$id=${competence.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    _jspx_th_form_form_1.setMethod("get");
    int[] _jspx_push_body_count_form_form_1 = new int[] { 0 };
    try {
      int _jspx_eval_form_form_1 = _jspx_th_form_form_1.doStartTag();
      if (_jspx_eval_form_form_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <input type=\"submit\" value=\"Delete\"></input>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_form_form_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_form_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_form_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_form_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_form_1.doFinally();
      _jspx_tagPool_form_form_method_action.reuse(_jspx_th_form_form_1);
    }
    return false;
  }

  private boolean _jspx_meth_form_input_5(javax.servlet.jsp.tagext.JspTag _jspx_th_form_form_2, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_form_2)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_input_5 = (org.springframework.web.servlet.tags.form.InputTag) _jspx_tagPool_form_input_path_nobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_input_5.setPageContext(_jspx_page_context);
    _jspx_th_form_input_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_form_2);
    _jspx_th_form_input_5.setPath("description");
    int[] _jspx_push_body_count_form_input_5 = new int[] { 0 };
    try {
      int _jspx_eval_form_input_5 = _jspx_th_form_input_5.doStartTag();
      if (_jspx_th_form_input_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_input_5[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_input_5.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_input_5.doFinally();
      _jspx_tagPool_form_input_path_nobody.reuse(_jspx_th_form_input_5);
    }
    return false;
  }

  private boolean _jspx_meth_c_import_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_import_1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _jspx_tagPool_c_import_url_nobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    _jspx_th_c_import_1.setPageContext(_jspx_page_context);
    _jspx_th_c_import_1.setParent(null);
    _jspx_th_c_import_1.setUrl("template/footer.jsp");
    int[] _jspx_push_body_count_c_import_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_import_1 = _jspx_th_c_import_1.doStartTag();
      if (_jspx_th_c_import_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_import_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_import_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_import_1.doFinally();
      _jspx_tagPool_c_import_url_nobody.reuse(_jspx_th_c_import_1);
    }
    return false;
  }
}
