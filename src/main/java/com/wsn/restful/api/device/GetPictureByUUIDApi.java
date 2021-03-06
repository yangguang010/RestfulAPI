package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.core.conf.ReadableStringProperty;
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
 * Created by songyangguang on 2018/1/17.
 */
public class GetPictureByUUIDApi extends AbstractAPI {
    private String accessToken;
    private String uuid;//设备sdk抓拍返回的uuid
    private int size;//图片大小，范围在[0~1280]
    private HttpPostMethod httpPostMethod;

    public GetPictureByUUIDApi(String url,String accessToken,String uuid,int size) {
        this.url = url;
        this.accessToken = accessToken;
        this.uuid = uuid;
        this.size = size;
        this.method = RequestInfo.Method.POST;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headBody = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headBody);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        if(uuid != null) {
            bodyMap.put("uuid",uuid);
        }
        if (size > 0 && size < 1280) {
            bodyMap.put("size",size);
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
