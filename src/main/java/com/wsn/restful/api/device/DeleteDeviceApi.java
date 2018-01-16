package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.NewDeviceResponse;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 删除设备
 * Created by songyangguang on 2018/1/12.
 */
public class DeleteDeviceApi extends AbstractAPI {
    //private String accessToken;
    private String deviceSerial;
    private HttpPostMethod httpPostMethod;

    public DeleteDeviceApi(String url,String accessToken,String deviceSerial) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        //设置http的header
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body部分
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);

        //设置完整的url地址
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<NewDeviceResponse> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
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
