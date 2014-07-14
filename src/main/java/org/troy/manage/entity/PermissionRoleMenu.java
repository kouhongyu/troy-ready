package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:30
 * Email:kouhongyu@163.com
 */
public class PermissionRoleMenu implements Serializable {
    private static final long serialVersionUID = -5203301414218833309L;
    private Long menuid;
    private Long roleid;

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}
