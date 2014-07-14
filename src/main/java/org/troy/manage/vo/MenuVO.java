package org.troy.manage.vo;

import org.troy.manage.entity.ResourceMenu;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 12-5-24
 * Time: 下午2:17
 * Email:kouhongyu@163.com
 */
public class MenuVO {

    private Long menuid;
    private String menucode;
    private String menuname;
    private Long methodid;
    private Integer effective;
    private String parameter;
    private String description;
    private Integer folder;

    private boolean isLeaf;
    private boolean expanded;
    private Long pid;

    private ResourceMenu resourceMenu;
    private ResourceMenu parentResourceMenu;

    public MenuVO(ResourceMenu resourceMenu) {

        this.menuid = resourceMenu.getId();
        this.menucode = resourceMenu.getMenucode();
        this.menuname = resourceMenu.getText();
//        this.methodid = resourceMenu.getUrl();
        this.effective = resourceMenu.getEffective();
        this.parameter = resourceMenu.getParameter();
        this.description = resourceMenu.getDescription();

        this.resourceMenu = resourceMenu;

        this.expanded = false;

    }

    private Long changePid() {
        if (parentResourceMenu == null) {
            return -1L;
        } else {
            return parentResourceMenu.getId();
        }
    }

    public Long getMenuid() {
        return menuid;
    }

    public void setMenuid(Long menuid) {
        this.menuid = menuid;
    }

    public String getMenucode() {
        return menucode;
    }

    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public Integer getFolder() {
        return folder;
    }

    public void setFolder(Integer folder) {
        this.folder = folder;
    }

    public Long getPid() {
        if (this.pid == null) {
            this.pid = changePid();
        }
        return this.pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getMethodid() {
        return methodid;
    }

    public void setMethodid(Long methodid) {
        this.methodid = methodid;
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

    public ResourceMenu getResourceMenu() {
        return resourceMenu;
    }

    public void setResourceMenu(ResourceMenu resourceMenu) {
        this.resourceMenu = resourceMenu;
    }

    public ResourceMenu getParentResourceMenu() {
        return parentResourceMenu;
    }

    public void setParentResourceMenu(ResourceMenu parentResourceMenu) {
        this.parentResourceMenu = parentResourceMenu;
    }
}
