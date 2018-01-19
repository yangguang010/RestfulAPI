package com.wsn.restful.servlet;

import com.wsn.restful.thread.GetAccessTokenThread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by songyangguang on 2018/1/18.
 */
public class initServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("************初始化initServlet****************");
        Thread getTokenThread = new GetAccessTokenThread();
        getTokenThread.start();
        super.init();
    }
}
