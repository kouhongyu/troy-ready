package org.troy.core.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 11-10-17
 * Time: 下午1:22
 * Email:kouhongyu@163.com
 */
public class PaginationTag extends TagSupport {
    public int doStartTag() throws JspException {
        try {
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            JspWriter out = pageContext.getOut();

            Pagination pagination = request.getAttribute(ConstVar.Page.PAGINATION) == null ? new Pagination() : (Pagination) request.getAttribute(ConstVar.Page.PAGINATION);

            out.print(PaginationUtil.pagerHtml(
                    pagination.getTotal(),
                    pagination.getCurrentPage(),
                    pagination.getPageSize(),
                    pagination.getViewPageCount(),
                    pagination.getToPage(),
                    pagination.getParamMap()));

            System.out.println(request.getContextPath());
            System.out.println(request.getPathInfo());
            System.out.println(request.getRequestURI());
            System.out.println(request.getRequestURL().toString());
            System.out.println(request.getQueryString());
            System.out.println(request.getServletPath());
            System.out.println(request.getLocalAddr());
            System.out.println(request.getReader().toString());
            System.out.println(request.getRemoteAddr());
            System.out.println(request.getRemoteHost());


        } catch (java.io.IOException e) {
            throw new JspTagException(e.getMessage());
        }

        return SKIP_BODY;
    }


}
