package org.troy.manage.entity;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 13-8-7<p/>
 * Time: 下午5:40<p/>
 * Email:kouhongyu@163.com<p/>
 */
public class Test implements Serializable{
    private Integer testid;
    private String testname;

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String toString() {
        return "Test{" +
                "testid=" + testid +
                ", testname='" + testname + '\'' +
                '}';
    }
}
