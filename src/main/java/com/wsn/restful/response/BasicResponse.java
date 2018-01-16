package com.wsn.restful.response;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Created by songyangguang on 2018/1/11.
 */
public class BasicResponse<T> {
    public String code; //返回类型码
    public String msg; //返回类型描述
    public T data; //返回数据data
    public PageResponse page; //返回分页信息

    @JsonProperty("data")
    public Object dataInternal;
    @JsonProperty("page")
    public Object pageInternal;
    @JsonIgnore
    public String json;

    public PageResponse getPage() {
        return page;
    }

    public void setPage(PageResponse page) {
        this.page = page;
    }
    @JsonGetter("page")
    public Object getPageInternal() {
        return pageInternal;
    }
    @JsonSetter("page")
    public void setPageInternal(Object pageInternal) {
        this.pageInternal = pageInternal;
    }

    @JsonGetter("data")
    public Object getDataInternal() {
        return dataInternal;
    }
    @JsonSetter("data")
    public void setDataInternal(Object dataInternal) {
        this.dataInternal = dataInternal;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
