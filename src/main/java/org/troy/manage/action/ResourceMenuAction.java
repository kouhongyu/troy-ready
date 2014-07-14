package org.troy.manage.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.manage.entity.ResourceMenu;
import org.troy.manage.service.PermissionService;
import org.troy.manage.vo.MenuVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-18<p/>
 * Time: 下午6:01<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class ResourceMenuAction extends GenericAction {


    private static final long serialVersionUID = -3479247153273745717L;


    public String editResourceMenu(){


        return SUCCESS;
    }

    public String removeResourceMenuAjax() {
        if (id == null) {
            putJson(STATUS, "没有传入菜单资源信息");
        } else {
            try {
                permissionService.removeResourceMenu(id);
            } catch (Exception e) {
                putJson(STATUS, e.getMessage());
            }
        }


        return SUCCESS;
    }
    public String addResourceMenuAjax() {
        if (resourceMenu == null) {
            putJson(STATUS, "没有传入菜单资源信息");
        } else {
            try {
                resourceMenu = permissionService.addResourceMenu(resourceMenu,pid);
                putJson("resourceMenu", resourceMenu);
            } catch (Exception e) {
                putJson(STATUS, e.getMessage());
            }
        }

        return SUCCESS;
    }
    public String saveResourceMenuAjax() {
        if (resourceMenu == null) {
            putJson(STATUS, "没有传入菜单资源信息");
        } else {
            try {
                permissionService.saveResourceMenu(resourceMenu);
                menuVO = new MenuVO(resourceMenu);
                menuVO.setParentResourceMenu(permissionService.getParentResourceMenu(resourceMenu));
                putJson("menu", menuVO);
            } catch (Exception e) {
                putJson(STATUS, e.getMessage());
            }
        }

        return SUCCESS;
    }

    public String getResourceMenuAjax() {
        if (id == null) {
            putJson(STATUS, "没有传入menuid");
        } else {
            resourceMenu = permissionService.getResourceMenu(id);
            if (resourceMenu == null) {
                putJson(STATUS, "没有找到菜单ID为“" + id + "”的菜单");
            } else {
                menuVO = new MenuVO(resourceMenu);
                menuVO.setParentResourceMenu(permissionService.getParentResourceMenu(resourceMenu));
                putJson("menu", menuVO);
            }
        }
        return SUCCESS;
    }

    public String resourceMenuList() {
        if (id == null) {
            menuJson = permissionService.loadMenu(null);
        } else {
            menuJson = permissionService.loadMenu(id);
        }

        putJson(DATA, menuJson);

        return SUCCESS;
    }


    @Autowired
    private PermissionService permissionService;
    private List<ResourceMenu> menuJson;
    private MenuVO menuVO;
    private Long id;
    private ResourceMenu resourceMenu;
    private Long pid;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public ResourceMenu getResourceMenu() {
        return resourceMenu;
    }

    public void setResourceMenu(ResourceMenu resourceMenu) {
        this.resourceMenu = resourceMenu;
    }

    public List<ResourceMenu> getMenuJson() {
        return menuJson;
    }

    public void setMenuJson(List<ResourceMenu> menuJson) {
        this.menuJson = menuJson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuVO getMenuVO() {
        return menuVO;
    }

    public void setMenuVO(MenuVO menuVO) {
        this.menuVO = menuVO;
    }


}
