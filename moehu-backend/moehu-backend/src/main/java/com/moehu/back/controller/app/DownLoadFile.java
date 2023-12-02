package com.moehu.back.controller.app;

import cn.hutool.extra.servlet.ServletUtil;
import com.moehu.back.dao.UserDao_new;
import com.moehu.back.model.GWFileModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Controller
@RequestMapping(value = "/download")
public class DownLoadFile {

    @Autowired
    UserDao_new userDao;

    @GetMapping("/aaa")
    @ResponseBody
    public void aaa() {
        System.out.println("进入================");
        System.out.println("进入================");
        System.out.println("进入================");
    }
    /**
     * @功能描述 下载文件:
     */
    @GetMapping("/hutool")
    public void downloadByHutool(@RequestParam(value = "file_id") String file_id) {
        System.out.println("file_id"+file_id);
        //防止中文乱码
//        GWFileModel model = userDao.getGWFileById(file_id);
//        if (model!=null){
//            File file = new File(model.getFileurl());
//            ServletUtil.write(response,file);
//        }
    }
}
