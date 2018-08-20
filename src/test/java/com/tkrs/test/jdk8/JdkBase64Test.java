package com.tkrs.test.jdk8;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.UUID;

/**
 * @ClassName JdkBase64Test
 * @Description 测试java8 Base64编码和解码
 * @Author
 * @Date 2018/8/10  11:11
 * @Version 1.0
 **/
public class JdkBase64Test {

    /**
     *在java8中,Base64已经成为Java类库的标准
     *Java8内置了Base64编码的编码器和解码器,BASE64工具类提供了一套静态方法获取下面三种Base64编解码器
     *基本:输出被映射到一组字符,A-Za-z0-9+/,编码不添加任何行标,输出的编码仅支持A-Za-z0-9+/
     *URL:输出映射到一组字符A-Za-z0-9+_,输出是URL和文件
     *MIME:输出隐射到MIME友好格式,输出每行不超过76字符,并且使用'\r'并跟随'\n'作为分割.编码输出最后没有行分割
     */

    @Test
    public  void testBase64() throws UnsupportedEncodingException {
        //基本编码
        String baseEncode = Base64.getEncoder().encodeToString("runoob?java".getBytes("utf-8"));
        System.out.println("Base64编码字符串(基本):"+baseEncode);
        //基本解码
        byte[] decodeBytes = Base64.getDecoder().decode(baseEncode);
        System.out.println("原始字符串:"+new String(decodeBytes,"utf-8"));
        //URL编码
        String urlEncode = Base64.getUrlEncoder().encodeToString("TutorialPoint?java8".getBytes("utf-8"));
        System.out.println("Base64编码字符串(URL):"+urlEncode);
        //URL解码
        byte[] urlDecodeBytes = Base64.getUrlDecoder().decode(urlEncode);
        System.out.println("原始字符串:"+new String(urlDecodeBytes,"utf-8"));
        StringBuilder sb=new StringBuilder();
        for( int i=0;i<10;i++){
            sb.append(UUID.randomUUID().toString());
        }
        System.out.println("原字符串:"+sb.toString());
        byte[] mimeBytes = sb.toString().getBytes("utf-8");
        String mimeEncodeBytes = Base64.getMimeEncoder().encodeToString(mimeBytes);
        System.out.println("Base64编码字符串(MIME):"+mimeEncodeBytes);
        byte[] mimeDecodeBytes = Base64.getMimeDecoder().decode(mimeEncodeBytes);
        System.out.println("原字符串:"+new String(mimeDecodeBytes,"utf-8"));
    }
}
