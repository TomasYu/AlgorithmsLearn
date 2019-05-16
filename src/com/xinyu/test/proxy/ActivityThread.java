package com.xinyu.test.proxy;

/**
 * Created by zy on 2019/4/17.
 */
public class ActivityThread {
    public static void main(String[] args) {
        HttpProxy httpProxy = new HttpProxy();
        httpProxy.get("",null);
    }

}
