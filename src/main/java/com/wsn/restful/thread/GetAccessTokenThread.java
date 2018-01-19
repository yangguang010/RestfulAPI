package com.wsn.restful.thread;

import com.wsn.restful.api.token.TokenPojo;
import com.wsn.restful.api.token.GetToken;
import com.wsn.restful.response.AccessToken;
import com.wsn.restful.response.BasicResponse;

/**
 * Created by songyangguang on 2018/1/18.
 */
public class GetAccessTokenThread extends Thread {
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        String appKey = "bbc722d53069481699222e9f0e2f7d62";
        String appSecret = "5041d0db1f7a685047ccc16c525b41a1";
        GetToken getToken = new GetToken(appKey,appSecret);
        TokenPojo token = new TokenPojo();
        //super.run();
        while (true) {
            try {
                BasicResponse<AccessToken> response = getToken.executeApi();
                token.setAccessToken(response.getData().getAccessToken());
                System.out.println("token="+token.getAccessToken());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
