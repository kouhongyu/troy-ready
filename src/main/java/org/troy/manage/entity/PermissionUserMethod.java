package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:31
 * Email:kouhongyu@163.com
 */
public class PermissionUserMethod implements Serializable {
    private static final long serialVersionUID = -7563856349329752677L;
    private Long adminid;
    private Long methodid;

    public Long getAdminid() {
        return adminid;
    }

    public void setAdminid(Long adminid) {
        this.adminid = adminid;
    }

    public Long getMethodid() {
        return methodid;
    }

    public void setMethodid(Long methodid) {
        this.methodid = methodid;
    }
}
