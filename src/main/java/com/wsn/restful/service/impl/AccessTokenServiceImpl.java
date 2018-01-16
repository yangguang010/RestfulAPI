package com.wsn.restful.service.impl;

import com.wsn.restful.api.token.GetToken;
import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.service.AccessTokenService;

/**
 * Created by songyangguang on 2018/1/11.
 */
public class AccessTokenServiceImpl implements AccessTokenService{
    @Override
    public BasicResponse<AccessToken> getAccessToken(String appKey, String appSecret) {

        GetToken getTokenApi = new GetToken(appKey,appSecret);
        BasicResponse<AccessToken> response = getTokenApi.executeApi();

        return response;
    }
}
