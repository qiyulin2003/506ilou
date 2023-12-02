package com.moehu.back.controller.app;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import com.moehu.back.annotation.AppRestController;
import com.moehu.back.annotation.UserLoginToken;
import com.moehu.back.dao.UserDao;
import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.GWModel;
import com.moehu.back.model.ResultModel;
import com.moehu.back.model.salary.DeptModel;
import com.moehu.back.model.salary.UserModel;
import com.moehu.back.service.TokenService;
import com.moehu.back.sm.LoSM2;
import com.moehu.back.sm.SM2Utils;
import com.moehu.back.utils.ResultUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.moehu.back.sm.LoSM2.decrypt;

@Slf4j
@RestController
@RequestMapping(value = "/dzgw")
@AppRestController
@Api(tags = "dzgw 公文相关的接口")
public class GWController {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserDao_new userDao;
    @PostMapping("/addgw")
    @UserLoginToken
    public ResultModel save(@RequestBody GWModel gwModel){
        System.out.println("进入创建公文页面");
        System.out.println(gwModel.getGwurl());
        // 公文文件管理
        //从pem文件里 读取 公钥 和 私钥
        File file = new File("D:/sm2/public_key.pem");
        if (!file.exists()){
            KeyPair pair = SecureUtil.generateKeyPair("SM2");
            PublicKey aPublic = pair.getPublic();
            PrivateKey aPrivate = pair.getPrivate();
            //公钥 key 和私钥 key 转文件
            SM2Utils.exportPublicKey(aPublic,"D:/sm2/public_key.pem");
            SM2Utils.exportPrivateKey(aPrivate,"D:/sm2/private_key.pem");
        }
        PublicKey pubk2 = SM2Utils.importPublicKey("D:/sm2/public_key.pem");
        PrivateKey priK2 = SM2Utils.importPrivateKey("D:/sm2/private_key.pem");

        //公钥加密
        SM2 sm2 = SmUtil.sm2();
        sm2.setPublicKey(pubk2);
        String encStr_content = sm2.encryptBcd(gwModel.getGwurl(), KeyType.PublicKey);
        System.err.println("加密完成："+encStr_content);
        gwModel.setGwurl(encStr_content);

//        String encStr_bz = sm2.encryptBcd(gwModel.getGwurl(), KeyType.PublicKey);
//        System.err.println("加密完成："+encStr_bz);
//        gwModel.setGwbz(encStr_bz);

        gwModel.setUser_id(tokenService.uid());
        userDao.addgw(gwModel);
        return ResultUtils.Success("发送成功");
    }

    @PostMapping("/getallgw")
    @UserLoginToken
    public ResultModel getallgw(){
        System.out.println("获取所有公文");
        // 公文文件管理
        //从pem文件里 读取 公钥 和 私钥
        File file = new File("D:/sm2/public_key.pem");
        if (!file.exists()){
            KeyPair pair = SecureUtil.generateKeyPair("SM2");
            PublicKey aPublic = pair.getPublic();
            PrivateKey aPrivate = pair.getPrivate();
            //公钥 key 和私钥 key 转文件
            SM2Utils.exportPublicKey(aPublic,"D:/sm2/public_key.pem");
            SM2Utils.exportPrivateKey(aPrivate,"D:/sm2/private_key.pem");
        }
        PublicKey pubk2 = SM2Utils.importPublicKey("D:/sm2/public_key.pem");
        PrivateKey priK2 = SM2Utils.importPrivateKey("D:/sm2/private_key.pem");


        List<GWModel>list = userDao.getallgw();
        for (int i = 0; i < list.size(); i++) {
            //私钥解密
            SM2 sm2obj = SmUtil.sm2();
            sm2obj.setPrivateKey(priK2);
            String encStr_bz = list.get(i).getGwbz();
            String encStr_content = list.get(i).getGwurl();
//            String decStr01 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_bz,KeyType.PrivateKey));
            String decStr02 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_content,KeyType.PrivateKey));
//            list.get(i).setGwbz(decStr01);
            list.get(i).setGwurl(decStr02);


//            发送方接收方部门信息
            com.moehu.back.model.salary.UserModel userModel = userDao.getuserbyid(list.get(i).getUser_id());
            UserModel userModel1 = userDao.getuserbyid(list.get(i).getRe_user());
            DeptModel send_dept = userDao.getdeptbyid(userModel.getDept_id());
            DeptModel re_dept = userDao.getdeptbyid(userModel1.getDept_id());

            list.get(i).setSend_dept(send_dept.getDept_name());
            list.get(i).setRe_dept(re_dept.getDept_name());
        }
        return ResultUtils.Success(list);
    }

    @PostMapping("/getmygw")
    @UserLoginToken
    public ResultModel getmygw(){
        System.out.println("获取我的所有公文");
        // 公文文件管理
        //从pem文件里 读取 公钥 和 私钥
        File file = new File("D:/sm2/public_key.pem");
        if (!file.exists()){
            KeyPair pair = SecureUtil.generateKeyPair("SM2");
            PublicKey aPublic = pair.getPublic();
            PrivateKey aPrivate = pair.getPrivate();
            //公钥 key 和私钥 key 转文件
            SM2Utils.exportPublicKey(aPublic,"D:/sm2/public_key.pem");
            SM2Utils.exportPrivateKey(aPrivate,"D:/sm2/private_key.pem");
        }
        PublicKey pubk2 = SM2Utils.importPublicKey("D:/sm2/public_key.pem");
        PrivateKey priK2 = SM2Utils.importPrivateKey("D:/sm2/private_key.pem");
        List<GWModel>list = userDao.getmyallgw(tokenService.uid());
        for (int i = 0; i < list.size(); i++) {
            //私钥解密
            SM2 sm2obj = SmUtil.sm2();
            sm2obj.setPrivateKey(priK2);
            String encStr_bz = list.get(i).getGwbz();
            String encStr_content = list.get(i).getGwurl();
//            String decStr01 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_bz,KeyType.PrivateKey));
            String decStr02 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_content,KeyType.PrivateKey));
//            list.get(i).setGwbz(decStr01);
            list.get(i).setGwurl(decStr02);
        }
        return ResultUtils.Success(list);
    }

    @PostMapping("/getmyregw")
    @UserLoginToken
    public ResultModel getmyregw(){
        System.out.println("获取我接收所有公文");
        // 公文文件管理
        //从pem文件里 读取 公钥 和 私钥
        File file = new File("D:/sm2/public_key.pem");
        if (!file.exists()){
            KeyPair pair = SecureUtil.generateKeyPair("SM2");
            PublicKey aPublic = pair.getPublic();
            PrivateKey aPrivate = pair.getPrivate();
            //公钥 key 和私钥 key 转文件
            SM2Utils.exportPublicKey(aPublic,"D:/sm2/public_key.pem");
            SM2Utils.exportPrivateKey(aPrivate,"D:/sm2/private_key.pem");
        }
        PublicKey pubk2 = SM2Utils.importPublicKey("D:/sm2/public_key.pem");
        PrivateKey priK2 = SM2Utils.importPrivateKey("D:/sm2/private_key.pem");
        List<GWModel>list = userDao.getmyreallgw(tokenService.uid());
        for (int i = 0; i < list.size(); i++) {
            //私钥解密
            SM2 sm2obj = SmUtil.sm2();
            sm2obj.setPrivateKey(priK2);
            String encStr_bz = list.get(i).getGwbz();
            String encStr_content = list.get(i).getGwurl();
//            String decStr01 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_bz,KeyType.PrivateKey));
            String decStr02 = StrUtil.utf8Str(sm2obj.decryptFromBcd(encStr_content,KeyType.PrivateKey));
//            list.get(i).setGwbz(decStr01);
            list.get(i).setGwurl(decStr02);
        }
        return ResultUtils.Success(list);
    }


    @PostMapping("/delgw")
    @UserLoginToken
    public ResultModel delgw(@RequestBody GWModel model){
        System.out.println("删除公文");
        // 查询公文
        GWModel gwModel = userDao.getGWById(model.getId());
        if (gwModel.getUser_id() == tokenService.uid()){
            if (gwModel.getStatus()==1){
                return ResultUtils.Error("公文已通过审核无法删除，请联系管理员");
            }else {
                userDao.delGWById(model.getId());
                return ResultUtils.Success("删除成功");
            }
        }else {
            return ResultUtils.Error("你没有权限删除");
        }
    }

    @PostMapping("/delgwbyadmin")
    @UserLoginToken
    public ResultModel delgwbyadmin(@RequestBody GWModel model){
        System.out.println("管理员删除公文");
        userDao.delGWById(model.getId());
        return ResultUtils.Success("删除成功");
    }

    @PostMapping("/auditgw")
    @UserLoginToken
    public ResultModel auditgw(@RequestBody GWModel model){
        System.out.println("管理员审核公文");
        userDao.auditgw(model);
        return ResultUtils.Success("设置成功");
    }


}
