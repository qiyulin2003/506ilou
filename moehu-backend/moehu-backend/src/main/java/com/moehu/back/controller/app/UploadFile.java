package com.moehu.back.controller.app;

import cn.hutool.extra.servlet.ServletUtil;
import com.moehu.back.annotation.AppRestController;
import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.GWFileModel;
import com.moehu.back.model.ResultModel;
import com.moehu.back.utils.EncryptionTools;
import com.moehu.back.utils.ResultUtils;
import com.moehu.back.utils.Tool;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping(value = "/file")
@AppRestController
@Api(tags = "上传公文相关的接口")
public class UploadFile {

    @Autowired
    UserDao_new userDao;
    @PostMapping("/uploadfile")
    public ResultModel uploadElementFile(@RequestParam("file") MultipartFile[] files) throws Exception {
        if(files.length==0){
            return ResultUtils.Error("文件不能为空");
        }

        String fileName = upload(files[0], files[0].getOriginalFilename());

        return ResultUtils.Success(fileName);
    }

    public String upload(MultipartFile img, String fileName) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String filePath = "D://dzgw//"+sdf.format(new Date())+"//";
        String date = sdf.format(new Date());
        String filePath = "D://dzgw//"+date+"//";
        System.out.println("======文件目录是：========="+filePath);
        File file = new File(filePath + fileName);

        if (!file.exists()) {
            System.out.println(filePath + fileName + "======文件夹不存在=========");
            boolean result = file.mkdirs();
            if (!result) {
                System.out.println("======创建文件夹=========");
            }
        }
        try {
            img.transferTo(file);
        } catch (IOException e) {
            System.out.println("======图片上传失败=========");
        }
        System.out.println("======返回图片地址========="+fileName);
        // 使用国密算法 加密文件
        EncryptionTools.encryptionOrDecryption(filePath + fileName,filePath,fileName,true);
        // 保存文件路径到数据库
        String uid = Tool.uuid();
        GWFileModel fileModel = new GWFileModel();
        fileModel.setId(uid);
        fileModel.setFilename(fileName);
        fileModel.setFilepath(filePath);
        fileModel.setFileurl(filePath + fileName);
        userDao.addfile(fileModel);
        return uid;
    }


    @GetMapping("/download")
    public void downloadByHutool(@RequestParam("file_id") String file_id) {
        //防止中文乱码
        System.out.println("============"+file_id);
//        response.setCharacterEncoding("UTF-8");
//        GWFileModel model = userDao.getGWFileById(file_id);
//        if (model!=null){
//            File file = new File(model.getFileurl());
//            ServletUtil.write(response,file);
//        }
    }

}
