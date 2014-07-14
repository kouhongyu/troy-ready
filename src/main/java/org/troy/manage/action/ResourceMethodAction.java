package org.troy.manage.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.ResourceMethod;
import org.troy.manage.service.ResourceService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-13<p/>
 * Time: 上午10:56<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class ResourceMethodAction extends GenericAction {

    private static final long serialVersionUID = 2826132995745923248L;


    public String resourceActionList() {
        try {

            PagingTool pagingTool = new PagingTool(resourceService.getResourceMethodTotal(resourceMethod),
                    this.getPageIndex(), this.getPageSize(), this.getSortOrder(), this.getSortField());
            if (resourceMethod != null) {
                pagingTool.putParameter("methodid", resourceMethod.getMethodid() == null ? null : resourceMethod.getMethodid().toString());
                pagingTool.putParameter("methodname", resourceMethod.getMethodname());
                pagingTool.putParameter("methodpath", resourceMethod.getMethodpath());
                pagingTool.putParameter("effective", resourceMethod.getEffective() == null ? null : resourceMethod.getEffective().toString());
            }

            List<ResourceMethod> resourceActionList = resourceService.getResourceMethodList(pagingTool);

            putJson(TOTAL, pagingTool.getTotal());
            putJson(DATA, resourceActionList);
        } catch (Exception e) {
            logger.error("Action资源列表",e);
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }

    public String saveResourceAction() {
        try {
            if (resourceMethod.getMethodid() == null || resourceMethod.getMethodid() == 0) {
                resourceService.saveResourceMethod(resourceMethod);
            } else {
                resourceService.updateResourceMethod(resourceMethod);
            }

        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }

    public String removeResourceAction() {
        try {
            resourceService.removeResourceMethod(resourceMethod);
        } catch (Exception e) {
            e.printStackTrace();
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    private static final Log logger = LogFactory.getLog(ResourceMethodAction.class);
    @Autowired
    private ResourceService resourceService;
    private ResourceMethod resourceMethod;

    public ResourceMethod getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(ResourceMethod resourceMethod) {
        this.resourceMethod = resourceMethod;
    }
}
