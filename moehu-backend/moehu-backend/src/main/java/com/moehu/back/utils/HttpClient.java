package com.moehu.back.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClient {
    public static JSONObject doGet(String url){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try{
            //通过默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            //创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            //httpGet.addHeader("Connection", "keep-alive");
            //设置请求头信息
            httpGet.addHeader("Accept", "application/json");
            //配置请求参数
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(35000) //设置连接主机服务超时时间
                    .setConnectionRequestTimeout(35000)//设置请求超时时间
                    .setSocketTimeout(60000)//设置数据读取超时时间
                    .build();
            //为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            //执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            //通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            //通过EntityUtils中的toString方法将结果转换为字符串，后续根据需要处理对应的reponse code
            result = EntityUtils.toString(entity);
        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭资源
            if(response != null){
                try {
                    response.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            if(httpClient != null){
                try{
                    httpClient.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        JSONObject jObject = JSONObject.parseObject(result);
        return jObject;
    }



    public static Integer GetHeight(JSONObject obj) {
        return Integer.parseInt(JSONObject.parseObject(
                obj.get("ImageHeight").toString()
        ).get("value").toString());
    }

    public static Integer GetWidth(JSONObject obj) {
        return Integer.parseInt(JSONObject.parseObject(
                obj.get("ImageWidth").toString()
        ).get("value").toString());
    }

    public static void main(String[] args) throws Exception {
        JSONObject a = HttpClient.doGet("https://moehu.oss-cn-shanghai.aliyuncs.com/img/0740e09074f543d48831941c80a4b702-image_picker8796465794820015628.jpg?x-oss-process=image/info");
        System.out.println(HttpClient.GetHeight(a));
        System.out.println(HttpClient.GetWidth(a));

    }
}
