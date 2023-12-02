package com.moehu.back.sm;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.util.encoders.Hex;
import org.junit.jupiter.api.Test;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SM2Test {

    public static void test1(){
        String text = "测试aaaaaaaaa";
        System.out.println("加密前内容："+text);
        SM2 sm2 = SmUtil.sm2();

        //第一种 使用随机密钥对
        String s = sm2.encryptBcd(text, KeyType.PublicKey);
        System.out.println("加密后内容："+s);
        String s1 = StrUtil.utf8Str(sm2.decryptFromBcd(s, KeyType.PrivateKey));

        System.out.println("解密后内容："+s1);
    }



    public static void test2(){
        String text = "<p>1111</p>";
        System.out.println("加密前内容："+text);

        //第二种  使用自定义密钥对
        KeyPair keyPair = SecureUtil.generateKeyPair("SM2");
        byte[] priKey = keyPair.getPrivate().getEncoded();
        byte[] pubKey = keyPair.getPublic().getEncoded();
        String pubKey_str = "";
        for (int i = 0; i < pubKey.length; i++) {
            pubKey_str+= pubKey[i];
        }
        System.out.println("公钥"+pubKey_str);
        String publicKeyHex = "";
        String privateKeyHex = "";

//        PrivateKey privateKey = keyPair.getPrivate();
//        PublicKey publicKey = keyPair.getPublic();

//        if (publicKey instanceof BCECPublicKey) {
//            //获取65字节非压缩缩的十六进制公钥串(0x04)
//            publicKeyHex = Hex.toHexString(((BCECPublicKey) publicKey).getQ().getEncoded(false));
//            System.out.println("---->SM2公钥：" + publicKeyHex);
//        }
//
//        if (privateKey instanceof BCECPrivateKey) {
//            //获取32字节十六进制私钥串
//            privateKeyHex = ((BCECPrivateKey) privateKey).getD().toString(16);
//            System.out.println("---->SM2私钥：" + privateKeyHex);
//        }

        System.err.println("=====================================");
        SM2 sm2obj = SmUtil.sm2(priKey,pubKey);
        //公钥加密，私钥解密
        String encStr = sm2obj.encryptBcd(text,KeyType.PublicKey);
        System.err.println("加密："+encStr);

        String decStr = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr,KeyType.PrivateKey));
        System.err.println("解密："+decStr);
        String aaa = "04B2CE157D78E1E473A56190DB90628DEE1484DAA4B82CB28E822D8BE4B5238DE1FF59742AB022076B53959F68198AD43454456195E11432D128ECC3E09CB4F76A67FEB096B0DFB62BFC8F9B2E5A86E2A6B69F270ADF52F82838CBE82C11A112D82A6AC84DDE306593EC8E13";
        System.out.println("jiemi"+StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr,KeyType.PrivateKey)));
    }

//    加密算法
    public static void jm(String text,byte[] pubKey){

    }


    public static void main(String[] args) {
//        KeyPair keyPair = SecureUtil.generateKeyPair("SM2");
//        byte[] priKey = keyPair.getPrivate().getEncoded();
//        byte[] pubKey = keyPair.getPublic().getEncoded();

        //第一种 使用随机密钥对
        test1();

        //第二种  使用自定义密钥对
//        test2();
//        test2_1();
        //第三种 生成pem文件,从pem文件里 读取 公钥 和 私钥,再进行 公钥加密，私钥解密
//        KeyPair pair = SecureUtil.generateKeyPair("SM2");
//
//        PublicKey aPublic = pair.getPublic();
//        PrivateKey aPrivate = pair.getPrivate();
//        //公钥 key 和私钥 key 转文件
//        SM2Utils.exportPublicKey(aPublic,"D:/sm2/public_key.pem");
//        SM2Utils.exportPrivateKey(aPrivate,"D:/sm2/private_key.pem");
//
//        test3();
    }

    /**
     * SM2非对称加密
     */
    public static void test3() {
        String text = "<p>1111</p>";
        System.err.println(text);

        //从pem文件里 读取 公钥 和 私钥
        PublicKey pubk2 = SM2Utils.importPublicKey("D:/sm2/public_key.pem");
        PrivateKey priK2 = SM2Utils.importPrivateKey("D:/sm2/private_key.pem");

        //公钥加密
        SM2 sm2 = SmUtil.sm2();
        sm2.setPublicKey(pubk2);
        String encStr = sm2.encryptBcd(text, KeyType.PublicKey);

        System.err.println(encStr);


        //私钥解密
        SM2 sm2obj = SmUtil.sm2();
        sm2obj.setPrivateKey(priK2);
        String decStr = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr,KeyType.PrivateKey));

        System.err.println(decStr);

    }

}
