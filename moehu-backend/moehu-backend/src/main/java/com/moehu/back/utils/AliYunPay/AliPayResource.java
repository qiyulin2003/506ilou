package com.moehu.back.utils.AliYunPay;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AliPayResource {
    private String appId;
    private String merchantPrivateKey;
    private String alipayPublicKey;

    private String notifyUrl;
    private String returnUrl;

    private String signType;
    private String charset;
    private String gatewayUrl;

    public AliPayResource(){
        this.appId = config.appId;
        this.merchantPrivateKey = config.merchantPrivateKey;
        this.alipayPublicKey=config.alipayPublicKey;
        this.notifyUrl = config.notifyUrl;
        this.returnUrl = config.returnUrl;
        this.signType = config.signType;
        this.charset = config.charset;
        this.gatewayUrl = config.gatewayUrl;
    }
}
