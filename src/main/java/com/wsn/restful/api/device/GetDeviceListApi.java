package com.wsn.restful.api.device;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.api.AbstractAPI;
import com.wsn.restful.http.HttpPostMethod;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;
import com.wsn.restful.response.DeviceListResponse;
import com.wsn.restful.response.PageResponse;
import com.wsn.restful.util.HttpUtil;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * 查询用户下设备基本信息列表
 *
 *    注：个人版设备接入上限：10台。无分页功能；如需要完善的功能，请升级为企业版
 *
 * Created by songyangguang on 2018/1/16.
 */
public class GetDeviceListApi extends AbstractAPI {
    private int pageStart;//分页起始页，从0开始
    private int pageSize;//分页大小，默认是10，最大是50
    private HttpPostMethod httpPostMethod;

    public GetDeviceListApi(String url,String accessToken,int pageStart,int pageSize) {
        this.url = url;
        this.accessToken = accessToken;
        this.method = RequestInfo.Method.POST;
        this.pageSize = pageSize;
        this.pageStart = pageStart;
        this.host = "open.ys7.com";
        this.content_type = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,content_type);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        if(pageStart >= 0) {
            bodyMap.put("pageStart",pageStart);
        }
        if(pageSize > 0){
            bodyMap.put("pageSize",pageSize);
        }

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<List<DeviceListResponse>> executeApi() {
        ObjectMapper mapper = new ObjectMapper();
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = mapper.readValue(httpResponse.getEntity().getContent(),BasicResponse.class);
            response.setJson(mapper.writeValueAsString(response));

            // 将json对象转化成DeviceList对象数组ArrayList(DeviceListResponse)
            List<DeviceListResponse> listResponses = new ArrayList<DeviceListResponse>();
            //DeviceListResponse[] deviceListResponses = new DeviceListResponse[];
            Object bs = response.getDataInternal();
            String stringJson = mapper.writeValueAsString(bs);
            listResponses = mapper.readValue(stringJson,List.class);
            //JavaType javaType = getCollectionType(ArrayList.class,DeviceListResponse.class);
            //Object data = mapper.readValue(mapper.writeValueAsString(response.getDataInternal()), DeviceListResponse.class);
            response.setData(listResponses);
            PageResponse page = mapper.readValue(mapper.writeValueAsString(response.getPageInternal()),PageResponse.class);
            response.setPage(page);
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
