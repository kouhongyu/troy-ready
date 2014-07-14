package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:29
 * Email:kouhongyu@163.com
 */
public class ResourceMethod implements Serializable {
    private static final long serialVersionUID = -4965548470835358184L;
    private Long methodid;
    private String methodname;
    private String methodpath;
    private Integer effective;
    private String description;


    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMethodid() {
        return methodid;
    }

    public void setMethodid(Long methodid) {
        this.methodid = methodid;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public String getMethodpath() {
        return methodpath;
    }

    public void setMethodpath(String methodpath) {
        this.methodpath = methodpath;
    }
}
