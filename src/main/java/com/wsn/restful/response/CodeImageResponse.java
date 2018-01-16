package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 二维码二进制数据格式
 * Created by songyangguang on 2018/1/15.
 */
public class CodeImageResponse {
    @JsonProperty("imageData")
    public String imageData;

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }
}
