package com.moehu.back;

import com.moehu.back.service.TokenService;
import com.moehu.back.utils.ImageTool;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.Random;

@SpringBootTest
public class test {
    @Autowired
    TokenService tokenService;
    public static void main(String[] args) throws IOException {
        File file =new File("C:/Users/Administrator/Desktop/new.jpg");

        File file1=ImageTool.changeSizeImg(file,200,200);

        OutputStream out=new FileOutputStream(file.getPath()+"new123.jpg");
        FileInputStream in = new  FileInputStream(file);
        //创建数组
        int n=0;
        int a=0;
        //1024字节 ,相当于每次读取1kb
        byte[] arr = new byte[1024];
        //循环读取,读到末尾会返回-1
        while((n=in.read(arr)) !=-1) {
            //将读取的内容写入到输出流当中
            out.write(arr, 0, n);
        }
        out.flush();
        out.close();
        in.close();

    }





}
