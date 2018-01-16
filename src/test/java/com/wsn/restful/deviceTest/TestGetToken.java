package com.wsn.restful.deviceTest;

import com.wsn.restful.api.token.GetToken;
import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.NewDeviceResponse;
import org.junit.Test;

/**
 * Created by songyangguang on 2018/1/11.
 */
public class TestGetToken {
    @Test
    public void getToken() {
        String appKey = "6bb1336cda084f31a8934e16b12317cd";
        String appSecret = "e07fb7ced4c3ffa951091024c6d430e9";
        GetToken tokenApi = new GetToken(appKey,appSecret);
        BasicResponse<AccessToken> response = tokenApi.executeApi();
        System.out.println("code: "+ response.getCode() + "  msg:" + response.getMsg() + " data:" + response.getDataInternal());
    }
}
