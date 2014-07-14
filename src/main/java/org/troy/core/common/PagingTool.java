package org.troy.core.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.<p/>
 * User: troy-kou<p/>
 * Date: 12-6-13<p/>
 * Time: 下午5:35<p/>
 * Email:kouhongyu@163.com<p/>
 */
public class PagingTool {

    public PagingTool(int total, int pageIndex, int pageSize) {
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;

        this.startIndex = (pageIndex + 1) * pageSize - pageSize;
    }

    public PagingTool(int total, int pageIndex, int pageSize, String sortOrder, String sortField) {
        this.total = total;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortOrder = sortOrder;
        this.sortField = sortField;

        this.startIndex = (pageIndex + 1) * pageSize - pageSize;
    }

    /**
     * 总数量
     */
    private int total;
    /**
     * 当前页索引，首页索引为0
     */
    private int pageIndex;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 查询起始索引，首条为0
     */
    private int startIndex;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序方式,asc;desc
     */
    private String sortOrder;

    private Map<String, String> parameterMap = new HashMap<String, String>();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "PagingTool{" +
                "total=" + total +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", sortField='" + sortField + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                '}';
    }

    public void putParameter(String name, String value) {
        parameterMap.put(name, value);

    }
}
