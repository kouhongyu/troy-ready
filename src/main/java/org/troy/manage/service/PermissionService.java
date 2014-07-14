package org.troy.manage.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.*;
import org.troy.manage.mapper.PermissionMapper;
import org.troy.manage.mapper.ResourceMapper;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:49
 * Email:kouhongyu@163.com
 */
@Service
@Transactional
public class PermissionService {

    public List<ResourceMenu> loadMenu(Long id) {
        List<ResourceMenu> menuList;

        if (id == null) {
            menuList = resourceMapper.selectResourceMenuRootList();
        } else {
            ResourceMenu resourceMenu = resourceMapper.selectResourceMenu(id);
            menuList = resourceMapper.selectResourceMenuList(resourceMenu.getMenucode());
        }
        return menuList;
    }

    public ResourceMenu getResourceMenu(Long menuid) {
        return resourceMapper.selectResourceMenu(menuid);
    }

    public ResourceMethod getResourceMethod(Long methodid) {
        return resourceMapper.selectResourceMethod(methodid);
    }

    public ResourceMenu getParentResourceMenu(ResourceMenu resourceMenu) {
        if (resourceMenu.getMenucode().length() > 4) {
            String menucode = resourceMenu.getMenucode().substring(0, resourceMenu.getMenucode().length() - 4);
            return resourceMapper.selectParentResourceMenu(menucode);
        } else {
            return null;
        }

    }

    public void saveResourceMenu(ResourceMenu resourceMenu) throws Exception {

        resourceMapper.updateResourceMenu(resourceMenu);
    }

    public ResourceMenu addResourceMenu(ResourceMenu resourceMenu, Long pid) {
        String menucode;
        if (pid == null || pid < 0) {//根节点
            menucode = resourceMapper.selectRootMenucodeMax();
            long l_menucode = Long.valueOf(menucode);
            menucode = String.valueOf(l_menucode + 1L);
        } else {//子节点
            ResourceMenu parentResourceMenu = resourceMapper.selectResourceMenu(pid);
            menucode = resourceMapper.selectNodeMenucodeMax(parentResourceMenu);
            if (StringUtils.isBlank(menucode)) {//没有其他子节点
                menucode = parentResourceMenu.getMenucode() + "1001";
            } else {
                long l_menucode = Long.valueOf(menucode.substring(parentResourceMenu.getMenucode().length(), menucode.length()));
                menucode = parentResourceMenu.getMenucode() + String.valueOf(l_menucode + 1L);
            }
            resourceMapper.updateResourceMenu(parentResourceMenu);
        }
        resourceMenu.setMenucode(menucode);
        resourceMapper.insertResourceMenu(resourceMenu);

        return resourceMenu;
    }

    public void removeResourceMenu(Long menuid) throws Exception {
        ResourceMenu resourceMenu = resourceMapper.selectResourceMenu(menuid);

        if (resourceMenu == null) {
            throw new Exception("菜单不存在");
        }
        List<ResourceMenu> list = resourceMapper.selectResourceMenuList(resourceMenu.getMenucode());
        if (list != null && list.size() > 0) {
            throw new Exception("有子菜单，不能删除");
        }
        resourceMapper.deleteResourceMenu(resourceMenu);
    }

    public List<PermissionRole> getPermissionRoleList(PagingTool pagingTool) {
        return permissionMapper.selectPermissionRoleList(pagingTool);
    }
    public int getPermissionRoleTotal(PermissionRole role) {
        return permissionMapper.selectPermissionRoleTotal(role);
    }
    public void addpermissionRole(PermissionRole role) {
        permissionMapper.insertPermissionRole(role);
    }
    public PermissionRole getPermissionRole(Long roleid) {
        return permissionMapper.selectPermissionRole(roleid);
    }
    public void savePermissionRole(PermissionRole role) {
        permissionMapper.updatePermissionRole(role);
    }
    public List<ResourceMenu> getResourceMenuListByRoleid(Long roleid) {
        return permissionMapper.selectResourceMenuListByRoleid(roleid);
    }
    public ResourceMenu getResourceMenu(String menucode) {
        return resourceMapper.selectResourceMenuByMenucode(menucode);
    }
    public void addRoleMenu(Long roleid, Long menuid) {
        PermissionRoleMenu permissionRoleMenu = new PermissionRoleMenu();
        permissionRoleMenu.setRoleid(roleid);
        permissionRoleMenu.setMenuid(menuid);
        permissionMapper.insertPermissionRoleMenu(permissionRoleMenu);
    }
    public void removeRoleMenu(Long roleid, Long menuid) {
        PermissionRoleMenu permissionRoleMenu = new PermissionRoleMenu();
        permissionRoleMenu.setRoleid(roleid);
        permissionRoleMenu.setMenuid(menuid);
        permissionMapper.deletePermissionRoleMenu(permissionRoleMenu);
    }
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    public List<ResourceMenu> loadPermissionMenuTree(AdminUser adminUser) {
        return resourceMapper.selectResourceMenuList("");
    }
}
