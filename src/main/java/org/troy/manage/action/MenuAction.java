package org.troy.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.manage.entity.ResourceMenu;
import org.troy.manage.service.PermissionService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午4:05
 * Email:kouhongyu@163.com
 */
@Controller
public class MenuAction extends GenericAction {

    public String loadMenu() {
        menuJson = permissionService.loadMenu(id);
        return SUCCESS;
    }

    public String toTab() {
        ResourceMenu menu = permissionService.getResourceMenu(id);
//        ResourceMethod method = permissionService.getResourceMethod(menu.getUrl());
//        toAction = method.getMethodpath();
        parameter = menu.getParameter();
        return SUCCESS;
    }

    private Long id;
    private String toAction;
    private String parameter;
    private List<ResourceMenu> menuJson;

    @Autowired
    private PermissionService permissionService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getToAction() {
        return toAction;
    }

    public void setToAction(String toAction) {
        this.toAction = toAction;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public List<ResourceMenu> getMenuJson() {
        return menuJson;
    }

    public void setMenuJson(List<ResourceMenu> menuJson) {
        this.menuJson = menuJson;
    }
}
