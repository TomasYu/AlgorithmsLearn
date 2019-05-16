package com.xinyu.test.proxy;

import java.util.Map;

/**
 * Created by zy on 2019/4/17.
 *
 * 网络请求的接口类
 */
public interface IHttpRequest {
    void get(String url , Callback callback);
    void post(String url,Map<String,String> postDate ,Callback callback);
}
