package com.xinyu.test;

// java版本
import org.apache.http.NameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SignMain {

    // 豆果api  http://bms.douguo.net/api/doc

    //    public static final String APP_KEY = "73586554";
    public static final String APP_KEY = "73586831";
//    public static final String APP_KEY = "99999999";
    //    public static final String APP_SECRET = "609A2AF70FFEE6CF55F3D7FE7F219C48";
    public static final String APP_SECRET = "407009575428ADBFEA777B8FB164238B";
//    public static final String APP_SECRET = "1B81BF7DCEEBB616F4443F2182655104";

    public static void main(String[] arg) {

        //视频搜索
//        String requestUrl = "http://api.open.douguo.com/recipe?method=douguo.recipe.msearchvideo&app_key="+APP_KEY+"&kw=牛蛙&page=1";
        //搜索服务
        String requestUrl = "http://api.open.douguo.com/recipe?method=douguo.recipe.msearch&app_key="+APP_KEY+"&kw=“西红柿”&page=1";
        //菜谱详情
//        String requestUrl = "http://api.open.douguo.com/recipe?method=douguo.recipe.mdetail&app_key="+APP_KEY+"&cook_id=2500088";
        URI url = null;
        try {
            url = new URI(requestUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String[] params = url.getQuery().split("&");

        ArrayList<NameValuePair> nv = new ArrayList<>();

        for (String param : params) {
            NameValuePair nameValuePair = new NameValuePair() {
                @Override
                public String getName() {
                    return param.split("=")[0];
                }

                @Override
                public String getValue() {
                    return param.split("=")[1];
                }
            };
            nv.add(nameValuePair);
        }
        // 按照升序排列参数
        Collections.sort(nv, new Comparator<NameValuePair>() {

            @Override
            public int compare(NameValuePair object1, NameValuePair object2) {
                return object1.getName().compareTo(object2.getName());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0, size = nv.size(); i < size; i++) {
            NameValuePair nameValue = nv.get(i);
            String key = nameValue.getName();
            String value = nameValue.getValue();
            sb.append(key);
            sb.append(value);
        }

        //拼接app_secret
        sb.append(APP_SECRET);
        String sign = MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        String requestUrlSigned = requestUrl.concat("&sign=").concat(sign);
//        System.out.println("签名后URL======>" + requestUrlSigned);
        System.out.println(requestUrlSigned);

    }

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }

    public static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}
