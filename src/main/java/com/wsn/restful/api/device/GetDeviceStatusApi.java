package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.DeviceStatusResponse;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;
import java.util.Map;

/**
 * 该接口用于根据序列号通道号获取
 * Created by songyangguang on 2018/1/17.
 */
public class GetDeviceStatusApi extends AbstractAPI{
    private String accessToken;
    private String deviceSerial;//设备序列号
    private int channel;//通道号，默认是1
    private HttpPostMethod httpPostMethod;

    public GetDeviceStatusApi(String url,String accessToken,String deviceSerial,int channel) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.channel = channel;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<DeviceStatusResponse> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
