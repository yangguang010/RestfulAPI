package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.SingleDeviceInfoResponse;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * 查询用户指定设备的基本信息
 * Created by songyangguang on 2018/1/16.
 */
public class GetOneDeviceInfoApi extends AbstractAPI{

    private String deviceSerial;
    private HttpPostMethod httpPostMethod;
    public GetOneDeviceInfoApi(String url,String accessToken,String deviceSerial) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
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

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<SingleDeviceInfoResponse> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));
            Object data = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), SingleDeviceInfoResponse.class);
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
