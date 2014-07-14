package org.troy.manage.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-7-24<p/>
 * Time: 上午9:00<p/>
 * Email:kouhongyu@163.com<p/>
 */
public class PermissionInterceptor extends AbstractInterceptor {


    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionContext actionContext = invocation.getInvocationContext();

        HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);

        StringBuffer url = request.getRequestURL();

        logger.info("---PermissionInterceptor--------------troy----------url : " +url);

        return invocation.invoke();
    }

    private static final Log logger = LogFactory.getLog(PermissionInterceptor.class);
    private static final long serialVersionUID = -3294282456670889945L;
}
