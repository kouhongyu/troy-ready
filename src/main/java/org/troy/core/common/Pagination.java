package org.troy.core.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: troy-kou
 * Date: 11-10-17
 * Time: 下午3:51
 * Email:kouhongyu@163.com
 */
public class Pagination {

    private int total = 0;
    private int currentPage = 1;
    private int pageTotal = 0;
    private int pageSize = 10;
    private int viewPageCount = 10;
    private int startIndex = 1;
    private Map paramMap = new HashMap();
    private String toPage;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.startIndex = currentPage * pageSize - pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getViewPageCount() {
        return viewPageCount;
    }

    public void setViewPageCount(int viewPageCount) {
        this.viewPageCount = viewPageCount;
    }

    public Map getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map paramMap) {
        this.paramMap = paramMap;
    }

    public void setToPage(String toPage) {
        this.toPage = toPage;
    }

    public String getToPage() {
        return toPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
