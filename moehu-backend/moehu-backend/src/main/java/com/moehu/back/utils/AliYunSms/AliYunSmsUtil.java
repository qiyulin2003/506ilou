package com.moehu.back.utils.AliYunSms;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.models.*;

import java.util.Random;

public class AliYunSmsUtil {

//    阿里云对接短信 发送短信验证码
    private static String accessKeyId = SMSConfig.AccessKey_ID;
    private static String accessKeySecret = SMSConfig.AccessKey_Secret;

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public int  SendSMS (String iphone,String TemplateCode,String Content){
        System.out.println("=====================SENDSMS");
        com.aliyun.dysmsapi20170525.Client client = null;
        try {
            System.out.println("========1");
            client = AliYunSmsUtil.createClient(SMSConfig.AccessKey_ID, SMSConfig.AccessKey_Secret);
            System.out.println(SMSConfig.AccessKey_ID);
            System.out.println(SMSConfig.AccessKey_Secret);
            System.out.println("============"+client);
            System.out.println(iphone);
            System.out.println(TemplateCode);
            System.out.println(Content);
            SendSmsRequest sendSmsRequest = new SendSmsRequest()
                    .setPhoneNumbers(iphone)
                    .setSignName("安徽虚拟纪元科技有限公司")
                    .setTemplateParam("{\"code\":\""+Content+"\"}")
                    .setTemplateCode(TemplateCode);
            // 复制代码运行请自行打印 API 的返回值
            client.sendSms(sendSmsRequest);
            System.out.println(" 短信发送成功");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("短信发送失败");
            return 0;
        }

    }



    public String  SendSMSYanZheng (String iphone,int TempCode){
        //1 用户注册验证码
        //2 身份验证验证码
        //3 修改密码验证码
        //4 信息变更验证码
//        进入短信发送验证码
        String TemplateCode="";
        switch (TempCode){
            case 1 :
                TemplateCode=SMSConfig.TemplateCode_1;
                break;
            case 2:
                TemplateCode=SMSConfig.TemplateCode_2;
                break;
            case 3 :
                TemplateCode=SMSConfig.TemplateCode_3;
                break;
            case 4:
                TemplateCode=SMSConfig.TemplateCode_4;
                break;
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<4;i++){
            sb.append(new Random().nextInt(10));
        }
        System.out.println("验证码："+sb.toString());
        int sendres = SendSMS(iphone,TemplateCode,sb.toString());
        if (sendres==1){
            return sb.toString();
        }else {
            return "";
        }

    }



}
