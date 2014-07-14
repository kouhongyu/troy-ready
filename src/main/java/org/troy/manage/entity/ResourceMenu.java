package org.troy.manage.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-23
 * Time: 下午3:29
 * Email:kouhongyu@163.com
 */
public class ResourceMenu implements Serializable {
    private static final long serialVersionUID = 9113580602435528309L;
    private Long id;
    private String menucode;
    private String text;
    private String url;
    private Integer effective;
    private String parameter;
    private String description;
    private String state;
    private List<ResourceMenu> resourceMenuList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getEffective() {
        return effective;
    }

    public void setEffective(Integer effective) {
        this.effective = effective;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getState() {
        if(resourceMenuList!=null && resourceMenuList.size()>0){
            state = "closed";
        }else{
            state = "open";
        }
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ResourceMenu> getResourceMenuList() {
        return resourceMenuList;
    }

    public void setResourceMenuList(List<ResourceMenu> resourceMenuList) {
        this.resourceMenuList = resourceMenuList;
    }
}
