package org.troy.core.common;

/**
 * Created by ShangHai China . <br>
 * Creator: Troy-Kou <br>
 * Date: 2008-12-18 <br>
 * Time: 11:36:36 <br>
 * E-Mail: kouhongyu@163.com <br>
 */
public interface ConstVar {

    public class Themes {
        public static final String SKIN = "blue";
    }

    public class Page{
        /**
         * 当前页
         */
        public static final String CURRENT_PAGE = "currentPage";
        /**
         * 总数量
         */
        public static final String TOTAL = "total";
        /**
         * 每页数量
         */
        public static final String PAGE_SIZE = "pageSize";
        /**
         * 每组显示页号数量
         */
        public static final String VIEW_PAGE_COUNT = "viewPageCount";
        /**
         * 搜索参数
         */
        public static final String PARAM_MAP = "paramMap";
        /**
         * 分页对象
         */
        public static final String PAGINATION = "pagination";
    }


}