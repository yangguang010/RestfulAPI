package com.wsn.restful.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by songyangguang on 2018/1/11.
 */
public class AccessToken {
    @JsonProperty("accessToken")
    public String accessToken;
    @JsonProperty("expireTime")
    public String expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
