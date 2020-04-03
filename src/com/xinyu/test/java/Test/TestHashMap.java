package com.xinyu.test.java.Test;

import java.util.HashMap;

/**
 * Created by zy on 2019/12/6.
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<MapKey,String> hashMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            hashMap.put(new MapKey(),"111");
        }
    }


    static class MapKey{
        @Override
        public int hashCode() {
            return 2;
        }
    }
}
