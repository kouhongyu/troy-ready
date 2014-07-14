package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:30
 * Email:kouhongyu@163.com
 */
public class PermissionRoleMethod implements Serializable {
    private static final long serialVersionUID = -7678818168697995871L;
    private Long methodid;
    private Long roleid;

    public Long getMethodid() {
        return methodid;
    }

    public void setMethodid(Long methodid) {
        this.methodid = methodid;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }
}
