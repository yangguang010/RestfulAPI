package com.wsn.restful.api.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.NewDeviceResponse;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by songyangguang on 2018/1/10.
 */
public class GetToken extends AbstractAPI{
    //private String url = "https://open.ys7.com/api/lapp/token/get";
    private String appKey;
    private String appSecret;
    //private String host;
    //private String Content_Type;
    private HttpPostMethod httpPostMethod;

    public GetToken(String appKey,String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.url = "https://open.ys7.com/api/lapp/token/get";
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";
        //设置https报文的头部
        Map<String,Object> headMap = new HashMap<String,Object>();
        headMap.put("Host",host);
        headMap.put("Content-Type",content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置https请求报文的body部分
        Map<String,Object> bodyMap = new HashMap<String,Object>();
        if (appKey != null) {
            bodyMap.put("appKey",appKey);
        }
        if (appSecret != null) {
            bodyMap.put("appSecret",appSecret);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<AccessToken> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));
            Object data = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), AccessToken.class);
            response.setData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpPostMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
