package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:31
 * Email:kouhongyu@163.com
 */
public class PermissionUserMenu implements Serializable {
    private static final long serialVersionUID = 2396331869568217235L;
    private Long menuid;
    private Long adminid;

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }
}
