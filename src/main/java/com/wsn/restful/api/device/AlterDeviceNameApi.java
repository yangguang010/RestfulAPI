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
import java.util.Map;

/**
 * 修改设备名称
 * Created by songyangguang on 2018/1/12.
 */
public class AlterDeviceNameApi extends AbstractAPI {
    private String deviceSerial;
    private String deviceName;//设备名称
    private HttpPostMethod httpPostMethod;

    public AlterDeviceNameApi(String url, String accessToken, String deviceSerial, String deviceName ) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.deviceName = deviceName;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        if(deviceName != null) {
            bodyMap.put("deviceName",deviceName);
        }
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
