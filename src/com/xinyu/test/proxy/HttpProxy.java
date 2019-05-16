package com.xinyu.test.proxy;

import java.util.Map;

/**
 * Created by zy on 2019/4/17.
 */
public class HttpProxy implements IHttpRequest{
    private IHttpRequest mHttpRequest;
    private static final int HTTP_CLIENT_TYPE = 1;
    private static final int HTTP_OKHTTP_TYPE = 2;
    private static int mHttpType = HTTP_OKHTTP_TYPE;
    HttpProxy(){
        switch (mHttpType) {
            case HTTP_CLIENT_TYPE:
                mHttpRequest = new HttpClient();
                break;
            case HTTP_OKHTTP_TYPE:
                mHttpRequest = new OKHttpClient();
                break;
        }
    }

    @Override
    public void get(String url, Callback callback) {
        mHttpRequest.get(url,callback);
    }

    @Override
    public void post(String url, Map<String, String> postDate, Callback callback) {
        mHttpRequest.post(url,postDate,callback);
    }
}
