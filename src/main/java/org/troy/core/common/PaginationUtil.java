package org.troy.core.common;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaginationUtil {

    public static final String NEXT_PAGE_NAME = ">";
    public static final String PREV_PAGE_NAME = "<";
    public static final String DISABLED = "disabled";
    public static final String CURRENT_PAGE_CLASS = "active";

    /**
     * s
     *
     * @param total         数据总条数<br>
     * @param currentPage   当前页<br>
     * @param pageSize      每页数据数量<br>
     * @param viewPageCount 分页面码每组显示数量<br>
     * @param url           跳转地址<br>
     * @param paramMap      搜索参数
     * @return 分页HTML
     */
    public static String pagerHtml(int total, int currentPage, int pageSize, int viewPageCount, String url, Map paramMap) {

        StringBuilder pageHtml = new StringBuilder();

        //总共的页数
        int pageTotal = getTotalPage(total, pageSize);

        if (pageTotal > 1) {
            pageHtml.append("<form id='PaginationUtilToPageForm' action='").append(url).append("' method='post'>");
            pageHtml.append("<input type='hidden' id='PaginationUtilCurrentPage' name='pagination.currentPage'>");
            pageHtml.append(processParam(paramMap));

            pageHtml.append("<div class='pagination'>");

            //是否有下一页
            boolean hasNextPage = getHasNextPage(currentPage, pageTotal);
            //下一组的起始页码
            int nextGroupPageNo = getNextGroupPageNo(currentPage, pageTotal, viewPageCount);

            if (currentPage > 1) {
                pageHtml.append(String.format("<li><a href='#' onclick='%s'>%s</a></li>", getFunction(currentPage - 1), PREV_PAGE_NAME));
                if (currentPage > viewPageCount) {
                    pageHtml.append(String.format("<li><a href='#' onclick='%s'>%s</a></li>", getFunction(1), 1));
                    pageHtml.append(String.format("<li class='%s'><a>...</a></li>", DISABLED));
                }

            } else {//当前是第一页
                pageHtml.append(String.format("<li class='%s'><a>%s</a></li>", DISABLED, PREV_PAGE_NAME));
            }

            //获得一组页码
            List<Integer> list = getViewPageNo(currentPage, pageTotal, viewPageCount);

            for (Integer pageNo : list) {
                if (pageNo == currentPage) {
                    pageHtml.append(String.format("<li class='%s'><a>%s</a></li>", CURRENT_PAGE_CLASS, pageNo));
                } else {
                    pageHtml.append(String.format("<li><a href='#' onclick='%s'>%s</a></li>",getFunction(pageNo), pageNo));
                }
            }

            if (hasNextPage) {//不是最后一页
                if (pageTotal > nextGroupPageNo) {//总页数，大于下一组的起始页码
                    pageHtml.append(String.format("<li class='%s'><a>...</a></li>", DISABLED));
                    pageHtml.append(String.format("<li><a href='#' onclick='%s'>%s</a></li>", getFunction(pageTotal), pageTotal));
                }
                pageHtml.append(String.format("<li><a href='#' onclick='%s'>%s</a></li>", getFunction(currentPage + 1), NEXT_PAGE_NAME));

            } else {//最后一页
                pageHtml.append(String.format("<li class='%s'><a>%s</a></li>", DISABLED, NEXT_PAGE_NAME));
            }

            pageHtml.append("</div>");
            pageHtml.append("</form>");

            pageHtml.append("<script>" +
                    "    function PaginationUtilToPage(pageNo){\n" +
                    "        document.getElementById('PaginationUtilCurrentPage').value = pageNo;\n" +
                    "        document.getElementById('PaginationUtilToPageForm').submit();\n" +
                    "    }\n" +
                    "</script>");
        }


        return pageHtml.toString();
    }

    private static String processParam(Map paramMap) {
        StringBuilder sb = new StringBuilder();
        Set<String> keySet = paramMap.keySet();
        for (String key : keySet) {
            sb.append("<input type='hidden' name='").append(key).append("' value='").append(paramMap.get(key)).append("'>");
        }
        return sb.toString();
    }

    protected static String getFunction(Integer pageNo) {
        return "PaginationUtilToPage(" + pageNo + ")";
    }

    /**
     * 是否还有下一页
     *
     * @param currentPage 当前页
     * @param pageTotal   总页数
     * @return
     */
    private static boolean getHasNextPage(int currentPage, int pageTotal) {
        boolean hasNextPage = false;

        if (pageTotal > 1 && currentPage != pageTotal) {
            hasNextPage = true;
        }
        return hasNextPage;
    }

    /**
     * 每组显示的页号
     *
     * @param pageNo    页码
     * @param pageCount 总页数
     * @param viewCount 每组显示的页数
     * @return
     */
    private static List<Integer> getViewPageNo(int pageNo, int pageCount, int viewCount) {
        List<Integer> list = new ArrayList<Integer>();
        int thisRow = getTotalPage(pageNo, viewCount);
        for (int i = (thisRow * viewCount - viewCount + 1); ((i <= (thisRow * viewCount)) && (i <= pageCount)); i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 下一组的起始页码
     *
     * @param pageNo    页码
     * @param pageCount 总页数
     * @param viewCount 每组显示的页数
     * @return
     */
    private static int getNextGroupPageNo(int pageNo, int pageCount, int viewCount) {
        int thisRow = getTotalPage(pageNo, viewCount);
        int j = pageCount <= (thisRow * viewCount) ? pageCount : (thisRow * viewCount);
        return j + 1;
    }

    /**
     * 页数
     *
     * @param total 总数量
     * @param size  每页数量
     * @return
     */
    public static int getTotalPage(int total, int size) {
        return total % size == 0 ? total / size : total / size + 1;
    }


}
