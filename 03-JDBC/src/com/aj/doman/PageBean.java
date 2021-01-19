package com.aj.doman;

import java.util.List;

/**
 * limit (currPage - 1) * pageSize,  currPage * pageSize - 1
 * 客户端提供 pageSize 和 currPage
 */
public class PageBean <T> {
    private Integer totalCount; // 总记录数
    private Integer pageSize;   // 每页记录数
    private Integer currPage;   // 当前页码
    private Integer pageCount;  // 总页数
    private List<T> list;       // 每页的数据

    public PageBean() {
        pageSize = 10;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : (totalCount / pageSize) + 1;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
