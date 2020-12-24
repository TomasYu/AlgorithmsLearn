package com.xinyu.test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String secret = "XXXXXXXXXXXXXXX";

        String algorithmForMac = "HmacSHA256";

        String method = "POST";
        String urlPath = "/voice/xm/gateway";
        String param = "";
        String xiaomiDate = "Wed, 18 Dec 2019 02:55:06 GMT";
        String host = "vhi-test.mercedes-benz.com.cn";
        String contentType = "application/json";
        String md5 = "VaCPjIT8J488XF4isT0Kig==";
        String source = new StringBuilder().append(method).append('\n').append(urlPath).append('\n').append(param).append('\n')
                .append(xiaomiDate).append('\n').append(host).append('\n')
                .append(contentType).append('\n').append(md5).append('\n').append("").toString();
        System.out.println(source);
        System.out.println("==================================");
        Mac mac = Mac.getInstance(algorithmForMac);
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decodeBase64(secret), algorithmForMac);
        mac.init(secretKeySpec);

        String signature = Hex.encodeHexString(mac.doFinal(source.getBytes("utf-8")));
        System.out.println(signature);
        System.out.println("6c6845b124f31f9b4f434176fe7a004ae6b55334e1553bb804a33cb9c7f60b18");
    }
}