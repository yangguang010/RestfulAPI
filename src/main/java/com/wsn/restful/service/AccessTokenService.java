package com.wsn.restful.service;

import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;

/**
 * Created by songyangguang on 2018/1/11.
 */
public interface AccessTokenService {
    /**
     * 管理员通过appkey和appSecret获得同行许可accesstoken
     * @param appKey
     * @param appSecret
     * @return
     */
    BasicResponse<AccessToken> getAccessToken(String appKey, String appSecret);
}
