package com.wsn.restful.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsn.restful.request.RequestInfo;
import com.wsn.restful.request.RequestInfo.Method;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by songyangguang on 2018/1/10.
 */
public abstract class AbstractAPI {
    public String accessToken;//连接密匙
    public String url;//连接的url
    public Method method;//请求方式
    public String host;
    public String content_type;
    public ObjectMapper mapper = new ObjectMapper();
}
