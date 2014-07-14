package org.troy.core.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.troy.core.common.Pagination;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-20<p/>
 * Time: 下午3:12<p/>
 * Email:kouhongyu@163.com<p/>
 */
@Controller
public class GenericAction extends ActionSupport {

    public static final String ADD = "add";
    public static final String UPDATE = "update";
    public static final String DELETE = "delete";

    public static final String STATUS = "status";
    public static final String DATA = "data";
    public static final String TOTAL = "total";


    public GenericAction() {
        json.put(STATUS, SUCCESS);
    }

    public void putStatus(String value) {
        this.json.put(STATUS, value);
    }

    public void putJson(String key, Object value) {
        this.json.put(key, value);
    }

    private Map json = new HashMap();
    protected Pagination pagination = new Pagination();
    private int pageIndex;
    private int pageSize;
    private String sortField;
    private String sortOrder;


    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        if(StringUtils.isBlank(sortField)){
            sortField = null;
            return null;
        }
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        if(StringUtils.isBlank(sortOrder)){
            sortOrder = null;
            return null;
        }
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
    public HttpServletRequest getRequest(){
        return ServletActionContext.getRequest();
    }
}
