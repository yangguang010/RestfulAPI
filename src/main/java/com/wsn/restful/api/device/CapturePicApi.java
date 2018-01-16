package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.CapturePicture;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * 抓怕图片
 * Created by songyangguang on 2018/1/15.
 */
public class CapturePicApi extends AbstractAPI {
    private String deviceSerial;
    private int channelNo;
    private HttpPostMethod httpPostMethod;

    public CapturePicApi(String url, String accessToken, String deviceSerial) {
        this.url = url;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.channelNo = 1;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        if (channelNo == 1) {
            bodyMap.put("channelNo",1);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<CapturePicture> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));
            Object data = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), CapturePicture.class);
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
