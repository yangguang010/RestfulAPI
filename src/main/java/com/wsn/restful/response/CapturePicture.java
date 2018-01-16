package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by songyangguang on 2018/1/15.
 */
public class CapturePicture {
    @JsonProperty("picUrl")
    public String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
