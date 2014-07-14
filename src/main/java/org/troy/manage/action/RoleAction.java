package org.troy.manage.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.troy.core.action.GenericAction;
import org.troy.core.common.PagingTool;
import org.troy.manage.entity.PermissionRole;
import org.troy.manage.entity.ResourceMenu;
import org.troy.manage.service.PermissionService;
import org.troy.manage.service.ResourceService;
import org.troy.manage.vo.ResourceMethodRoleVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-7-31<p/>
 * Time: 下午4:38<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class RoleAction extends GenericAction {

    private static final long serialVersionUID = 1648075256715063793L;

    public String getResourceActionRoleVOListByRoleid() {
        try {

            PagingTool pagingTool = new PagingTool(resourceService.getResourceMethodRoleVOTotal(resourceActionRoleVO),
                    this.getPageIndex(), this.getPageSize(), this.getSortOrder(), this.getSortField());

            pagingTool.putParameter("roleid",String.valueOf(roleid));

            if (resourceActionRoleVO != null) {
                pagingTool.putParameter("methodid", resourceActionRoleVO.getMethodid() == null ? null : resourceActionRoleVO.getMethodid().toString());
                pagingTool.putParameter("methodname", resourceActionRoleVO.getMethodname());
                pagingTool.putParameter("methodpath", resourceActionRoleVO.getMethodpath());
            }

            List<ResourceMethodRoleVO> resourceActionList = resourceService.getResourceMethodRoleVOList(pagingTool);

            putJson(TOTAL, pagingTool.getTotal());
            putJson(DATA, resourceActionList);
        } catch (Exception e) {
            logger.error("Action资源列表",e);
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }

    public String removeRoleMenu() {
        try {
            if (roleid == null || roleid == 0) {
                putJson(STATUS, "没有传入roleid");
            }else if (StringUtils.isBlank(menucode)){
                putJson(STATUS, "没有传入menucode");
            } else {

                ResourceMenu resourceMenu = permissionService.getResourceMenu(menucode);

                permissionService.removeRoleMenu(roleid,resourceMenu.getId());
            }

        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }
    public String addRoleMenu() {
        try {
            if (roleid == null || roleid == 0) {
                putJson(STATUS, "没有传入roleid");
            }else if (StringUtils.isBlank(menucode)){
                putJson(STATUS, "没有传入menucode");
            } else {

                ResourceMenu resourceMenu = permissionService.getResourceMenu(menucode);

                permissionService.addRoleMenu(roleid,resourceMenu.getId());
            }

        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    /**
     * @return
     * @throws Exception
     */
    public String getResourceMenuListByRoleid() {
        try {
            if (roleid == null || roleid == 0) {
                putJson(STATUS, "没有传入roleid");
            } else {
                List<ResourceMenu> resourceMenuList = permissionService.getResourceMenuListByRoleid(roleid);

                List<String> list = new ArrayList<String>();

                for(ResourceMenu resourceMenu:resourceMenuList){
                    list.add(resourceMenu.getMenucode());
                }

                putJson("menucodes", StringUtils.join(list,","));
            }

        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }


        return SUCCESS;
    }

    public String toRoleEdit() {
        try {

            role = permissionService.getPermissionRole(role.getRoleid());

        } catch (Exception e) {
            logger.error(e);
        }

        return SUCCESS;
    }


    public String savePermissionRole() throws Exception {

        try {
            if (role == null) {
                putJson(STATUS, "没有传入角色信息");
            } else {
                permissionService.savePermissionRole(role);
                putJson("role", role);
            }
        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }

    public String getPermissionRole() throws Exception {
        try {
            if (roleid == null || roleid == 0) {
                putJson(STATUS, "没有传入roleid");
            } else {
                role = permissionService.getPermissionRole(roleid);
                if (role == null) {
                    putJson(STATUS, "没有找到菜单ID为“" + roleid + "”的用户");
                } else {
                    putJson("role", role);
                }
            }

        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }

    public String addPermissionRole() throws Exception {
        try {
            if (role == null) {
                putJson(STATUS, "没有传入角色信息");
            } else {
                permissionService.addpermissionRole(role);
                putJson("role", role);
            }
        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }
        return SUCCESS;
    }

    public String roleList() {

        try {
            PagingTool pagingTool = new PagingTool(permissionService.getPermissionRoleTotal(role),
                    this.getPageIndex(), this.getPageSize(), this.getSortOrder(), this.getSortField());
            if (role != null) {
                pagingTool.putParameter("rolename", role.getRolename());
            }
            roleList = permissionService.getPermissionRoleList(pagingTool);
            putJson(TOTAL, pagingTool.getTotal());
            putJson(DATA, roleList);

        } catch (Exception e) {
            logger.error(e);
            putJson(STATUS, e.getMessage());
        }

        return SUCCESS;
    }


    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ResourceService resourceService;

    private Long roleid;
    private PermissionRole role;
    private List<PermissionRole> roleList;
    private String menucode;
    private Long actionid;
    private ResourceMethodRoleVO resourceActionRoleVO;

    private static final Log logger = LogFactory.getLog(RoleAction.class);

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public PermissionRole getRole() {
        return role;
    }

    public void setRole(PermissionRole role) {
        this.role = role;
    }

    public List<PermissionRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<PermissionRole> roleList) {
        this.roleList = roleList;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public Long getActionid() {
        return actionid;
    }

    public void setActionid(Long actionid) {
        this.actionid = actionid;
    }

    public ResourceMethodRoleVO getResourceActionRoleVO() {
        return resourceActionRoleVO;
    }

    public void setResourceActionRoleVO(ResourceMethodRoleVO resourceActionRoleVO) {
        this.resourceActionRoleVO = resourceActionRoleVO;
    }
}
