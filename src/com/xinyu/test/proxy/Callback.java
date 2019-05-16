package com.xinyu.test.proxy;

/**
 * Created by zy on 2019/4/17.
 */
public interface Callback {

    void onSuccess(String json);

    void onError(int errorCode);
}
