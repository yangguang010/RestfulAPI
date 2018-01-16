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
 * 修改设备视频加密密码（设置重置后修改的密码失效）
 * Created by songyangguang on 2018/1/15.
 */
public class UpdatePassword extends AbstractAPI{
    private String deviceSerial;
    private String oldPassword;//视频加密的旧密码
    private String newPassword;//视频加密的新密码
    private HttpPostMethod httpPostMethod;

    /**
     * 初始化
     * @param url
     * @param accessToken
     * @param deviceSerial 设备序列号
     * @param oldPassword  旧密码
     * @param newPassword  新密码
     */
    public UpdatePassword ( String url,String accessToken,String deviceSerial, String oldPassword,String newPassword) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
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
        if (oldPassword != null) {
            bodyMap.put("oldPassword",oldPassword);
        }
        if (newPassword != null) {
            bodyMap.put("newPassword",newPassword);
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
