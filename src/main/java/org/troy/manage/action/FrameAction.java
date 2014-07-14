package org.troy.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.manage.entity.AdminUser;
import org.troy.manage.entity.ResourceMenu;
import org.troy.manage.entity.ResourceMethod;
import org.troy.manage.service.PermissionService;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 14-1-25<p/>
 * Time: 上午11:20<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class FrameAction extends GenericAction {

    private static final long serialVersionUID = 5630642166815788384L;

    public String getMethod(){
        try {
            ResourceMenu resourceMenu = permissionService.getResourceMenu(menuid);
            putJson("resourceMenu", resourceMenu);
        } catch (Exception e) {
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }


    public String main() {

        menuTree = permissionService.loadPermissionMenuTree(adminUser);

        treeString = changeTreeString(menuTree);
        System.out.println(treeString);
        return SUCCESS;
    }

    private String changeTreeString(List<ResourceMenu> menuTree) {
        StringBuilder sb = new StringBuilder();
        for (ResourceMenu resourceMenu : menuTree) {
            if (resourceMenu.getResourceMenuList()!=null && resourceMenu.getResourceMenuList().size()>0 ) {//菜单
                sb.append("<li data-options=\"state:'closed'\">");
                sb.append("<span>").append(resourceMenu.getText()).append("</span>");

            } else {//节点
                sb.append("<li>");
                sb.append(" <span>");
                sb.append("     <a onclick=\"addPanel(").append(resourceMenu.getId()).append(")\">").append(resourceMenu.getText()).append("</a>");
                sb.append(" </span>");
            }

            if (resourceMenu.getResourceMenuList() != null && resourceMenu.getResourceMenuList().size() > 0) {
                sb.append("<ul>");
                sb.append(changeTreeString(resourceMenu.getResourceMenuList()));
                sb.append("</ul>");
            }
            sb.append("</li>");
        }
        return sb.toString();
    }

    private Long id;
    private Long menuid;
    private List<ResourceMenu> menuJson;
    private List<ResourceMenu> menuTree;
    private AdminUser adminUser;
    private ResourceMethod resourceMethod;
    private String treeString;

    @Autowired
    private PermissionService permissionService;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ResourceMenu> getMenuJson() {
        return menuJson;
    }

    public void setMenuJson(List<ResourceMenu> menuJson) {
        this.menuJson = menuJson;
    }

    public PermissionService getPermissionService() {
        return permissionService;
    }

    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public List<ResourceMenu> getMenuTree() {
        return menuTree;
    }

    public void setMenuTree(List<ResourceMenu> menuTree) {
        this.menuTree = menuTree;
    }

    public String getTreeString() {
        return treeString;
    }

    public void setTreeString(String treeString) {
        this.treeString = treeString;
    }

    public ResourceMethod getResourceMethod() {
        return resourceMethod;
    }

    public void setResourceMethod(ResourceMethod resourceMethod) {
        this.resourceMethod = resourceMethod;
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }
}
