package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.CapturePicture;
import com.wsn.restful.response.CodeImageResponse;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成设备扫描配网二维码二进制数据
 * Created by songyangguang on 2018/1/15.
 */
public class QrcodeWiFiApi extends AbstractAPI{
    private String ssid;//路由器SSID，即wifi名字，建议不要设置中文名称
    private String password;//WiFi密码
    private HttpPostMethod httpPostMethod;

    public QrcodeWiFiApi(String url,String accessToken, String ssid, String password) {
        this.accessToken = accessToken;
        this.url = url;
        this.ssid = ssid;
        this.password = password;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        if( ssid != null) {
            bodyMap.put("ssid",ssid);
        }
        if( password != null) {
            bodyMap.put("password", password);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<CodeImageResponse> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));
            Object data = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), CodeImageResponse.class);
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
