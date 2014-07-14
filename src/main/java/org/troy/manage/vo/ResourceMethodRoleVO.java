package org.troy.manage.vo;

import org.troy.manage.entity.ResourceMethod;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-8-20<p/>
 * Time: 下午5:30<p/>
 * Email:kouhongyu@163.com<p/>
 */
public class ResourceMethodRoleVO extends ResourceMethod {

    private static final long serialVersionUID = -7647245181372390393L;

    private int checked;

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
