package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

import static java.lang.System.out;

@Controller
public class FileController {
    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file")CommonsMultipartFile file, HttpServletRequest request) throws IOException{
        String uploadFileName = file.getOriginalFilename();
        if("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        out.println("上传文件名"+uploadFileName);
        String path = request.getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        out.println("上传文件保存地址："+realPath);
        //文件输入流
        InputStream is = file.getInputStream();
        //文件输出流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName));
        int len=0;
        int count=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            count++;
            System.out.println(buffer);
            os.flush();
        }
        out.println(count);
        out.println("上传成功");
        os.close();
        is.close();
        return "redirect:/index.jsp";
    }
    @RequestMapping("/upload2")
    public String fileUpload2(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        String path = request.getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        out.println("上传文件保存地址："+realPath);
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));
        return "redirect:/index.jsp";
    }

    /**
     * @description  指定文件名下载
     * @date   2020/7/29 14:54
     * @return      java.lang.String
     * @Exception  IOException
     **/
    @RequestMapping("/download")
    public String download(HttpServletResponse response,HttpServletRequest request) throws IOException {

        String path = request.getRealPath("/upload");
        String fileName = "g.jpg";
        response.reset();
        response.setCharacterEncoding("UTF-8");
        //
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        File file = new File(path,fileName);
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] buff = new byte[1024];
        int index=0;
        int count=0;
        while ((index=inputStream.read(buff))!=-1){
            count++;
            outputStream.write(buff,0,index);
            System.out.println(buff);
            outputStream.flush();
        }
        System.out.println(count);
        outputStream.close();
        inputStream.close();
        return null;
    }




}
