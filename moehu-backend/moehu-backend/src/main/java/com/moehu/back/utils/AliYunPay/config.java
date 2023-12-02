package com.moehu.back.utils.AliYunPay;

public class config {
    private config() { }

//   # 应用ID，您的APPID
public static String appId="2021xxxx";
//   # 支付宝公私钥生成地址：https://miniu.alipay.com/keytool/create
//   # 商户私钥，您的PKCS8格式RSA2私钥
public static String merchantPrivateKey="第一次生成的私钥";
//   # 支付宝公钥，查看地址：https://openhome.alipay.com/platform/keyManage.htm
public static String alipayPublicKey="支付宝公钥";
//   # 页面跳转异步通知页面路径，需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
public static String notifyUrl="http://5ktbak.natappfree.cc/payment/alipay";
//   # 页面跳转同步通知页面路径，需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
public static String returnUrl="http://5ktbak.natappfree.cc/alipayResult";

//   # 签名方式
public static String signType="RSA2";
//    # 字符编码格式
public static String charset="utf-8";
//            # 支付宝网关
public static String gatewayUrl="https://openapi.alipaydev.com/gateway.do";

}
