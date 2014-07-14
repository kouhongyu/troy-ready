package org.troy.manage.mapper;

import org.springframework.stereotype.Repository;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.PermissionRole;
import org.troy.manage.entity.PermissionRoleMethod;
import org.troy.manage.entity.PermissionRoleMenu;
import org.troy.manage.entity.ResourceMenu;

import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-7-31<p/>
 * Time: 下午4:49<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Repository
public interface PermissionMapper {

    public List<PermissionRole> selectPermissionRoleList(PagingTool pagingTool);

    public int selectPermissionRoleTotal(PermissionRole role);

    public void insertPermissionRole(PermissionRole role);

    public PermissionRole selectPermissionRole(Long roleid);

    public void updatePermissionRole(PermissionRole role);

    public List<ResourceMenu> selectResourceMenuListByRoleid(Long roleid);

    public void insertPermissionRoleMenu(PermissionRoleMenu permissionRoleMenu);

    public void deletePermissionRoleMenu(PermissionRoleMenu permissionRoleMenu);

    public PermissionRoleMethod selectPermissionRoleMethod(PermissionRoleMethod roleAction);
}
