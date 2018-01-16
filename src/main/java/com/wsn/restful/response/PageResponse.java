package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by songyangguang on 2018/1/16.
 */
public class PageResponse {
    @JsonProperty("total")
    public int total;
    @JsonProperty("page")
    public int page;
    @JsonProperty("size")
    public int size;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
