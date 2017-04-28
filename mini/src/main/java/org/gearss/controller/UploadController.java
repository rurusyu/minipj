package org.gearss.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    
    
    @PostMapping(name = "/upload", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file)throws Exception{
        
        System.out.println("---------------"+file.getOriginalFilename());
        
        String fileName=file.getOriginalFilename();
        
        IOUtils.copy(file.getInputStream(), new FileOutputStream("C:\\zzz\\po\\"+fileName));
        
    }
    @GetMapping(name = "/display", produces = {"image/jpg"})
    @ResponseBody
    public byte[] display(String fileName) throws Exception {
        
        InputStream fin = new FileInputStream("C:\\zzz\\po\\" + fileName);
        
        byte[] arr = IOUtils.toByteArray(fin); //byte로 뿌리기
        
        return arr;
    }
    
    
}