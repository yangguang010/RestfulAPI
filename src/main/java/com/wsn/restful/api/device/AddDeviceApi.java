package com.wsn.restful.api.device;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.NewDeviceResponse;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by songyangguang on 2018/1/10.
 */
public class AddDeviceApi extends AbstractAPI {
    //private String accessToken;//授权过程获取的access_token
    private String deviceSerial;//设备的序列号
    private String validateCode;//设备验证码，设备机身上的六位大写字母
    private HttpPostMethod httpMethod;//请求方式


    public AddDeviceApi (String url, String accessToken, String deviceSerial,String validateCode) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.validateCode = validateCode;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        Map<String,Object> headMap = new HashMap<String,Object>();
        httpMethod = new HttpPostMethod(method);
        headMap.put("Host",host);
        headMap.put("Content_Type",content_type);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = new HashMap<String,Object>();
        if (accessToken != null) {
            bodyMap.put("accessToken",accessToken);
        }
        if (deviceSerial != null) {
            bodyMap.put("deviceSerial",deviceSerial);
        }
        if (validateCode != null) {
            bodyMap.put("validateCode",validateCode);
        }
    /*
        String json = null;
        ObjectMapper remapper = new ObjectMapper();

        try {
            json = remapper.writeValueAsString(bodyMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        ((HttpPostMethod)httpMethod).setEntity(json);
    */
        httpMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<NewDeviceResponse> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
