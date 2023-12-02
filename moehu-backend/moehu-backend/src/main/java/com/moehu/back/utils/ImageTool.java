package com.moehu.back.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

//图片处理工具类
public class ImageTool {
//    改变图片的大小 将图片文件和大小传入 生成规定图片后返回
    public static File changeSizeImg(File imagfile,int w, int h) throws IOException {
        Thumbnails.of(imagfile).size(w,h).toFile(imagfile);
        return imagfile;
    }
//    缩放 传入图片以及缩放倍数
    public static File scale(File imagfile,double scale) throws IOException {
        Thumbnails.of(imagfile).scale(scale).toFile(imagfile);
        return imagfile;
    }
//    居中裁剪
    public static File region(File imagfile,int w,int h) throws IOException {
        Thumbnails.of(imagfile).scale(1).sourceRegion(Positions.CENTER,w,h).toFile(imagfile);
        return imagfile;
    }

    public static File caijian(File imagfile,int x,int y,int w,int h) throws IOException {
        Thumbnails.of(imagfile).sourceRegion(x,y,w,h).size(w,w).keepAspectRatio(false).toFile(imagfile);
        return imagfile;
    }

    //    添加水印
//    public static File wasterMask(File imagfile) throws IOException {
//        Thumbnails.of(imagfile).scale(1).watermark(Positions.TOP_RIGHT, ImageIO.read(new File(waterImg)),0.6f).toFile(imagfile);
//        return imagfile;
//    }


    public static File MultipartFileToFile(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        InputStream in = file.getInputStream();
        long timestap= new Date().getTime();
        OutputStream out = new FileOutputStream("D:\\upload\\" +timestap+filename);
        //创建数组
        int n=0;
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
        File file1=new File("D:\\upload\\" +timestap+filename);
        return file1;
    }

    public static MultipartFile FileToMultipartFile (File file) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(file);
        MultipartFile file1=new MockMultipartFile(file.getName(),file.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
        return file1;
    }

    @Test
    public static void main(String[] args) {
        String url="https://moehu01.oss-cn-shanghai.aliyuncs.com/img/37da21be0ed0456890670da22260d391-picture.jpg";
        System.out.println(url.split("/")[url.split("/").length-1]);
//        File file=new File("https://moehu01.oss-cn-shanghai.aliyuncs.com/img/37da21be0ed0456890670da22260d391-picture.jpg");
//        try {
//            URL url=new URL("https://moehu01.oss-cn-shanghai.aliyuncs.com/img/37da21be0ed0456890670da22260d391-picture.jpg");
//            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(10*1000);
//            InputStream in=conn.getInputStream();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            byte[] buffer = new byte[1024];
//            int len=0;
//            while ((len=in.read(buffer))!=-1){
//                out.write(buffer,0,len);
//            }
//            byte[]data=out.toByteArray();
//            File file=new File("D:\\upload\\img_url.jpg");
//
//
//
//            FileOutputStream outputStream=new FileOutputStream(file);
//            outputStream.write(data);
//
////            caijian(file,1,2);
//            outputStream.close();
//            in.close();
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}
