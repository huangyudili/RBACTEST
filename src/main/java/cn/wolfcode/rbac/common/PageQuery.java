package cn.wolfcode.rbac.common;

public class PageQuery {
    private Integer currentPage=1;
    private Integer pageSize=5;

    public PageQuery() {
    }

    public PageQuery(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public PageQuery(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
