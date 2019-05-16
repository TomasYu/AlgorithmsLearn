package com.xinyu.test.proxy;

import java.util.Map;

/**
 * Created by zy on 2019/4/17.
 */
public class OKHttpClient implements IHttpRequest{
    @Override
    public void get(String url, Callback callback) {
        System.out.println("OKHttpClient get");

    }

    @Override
    public void post(String url, Map<String, String> postDate, Callback callback) {
        System.out.println("OKHttpClient post");

    }
}
