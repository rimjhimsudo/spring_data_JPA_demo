package com.springwithmysqldemo.sqlspringdemo.helper;

import ch.qos.logback.classic.spi.ClassPackagingData;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    //static path,not dynamic for now
    //public final String UPLOAD_DIR="D:\\SpringBootProjects2022\\sql-spring-demo\\sql-spring-demo\\src\\main\\resources\\static\\employeeData";  //all single slash becomes double slash
    //dynamic path
    public final String UPLOAD_DIR=new ClassPathResource("static/employeeData/").getFile().getAbsolutePath(); //no more dependency on local system
    //classpath gives error coz above statement run on running so throw exception in constrctor
    public FileUploadHelper() throws IOException {

    }

    //this method will read file from parameter and write in UPLOAD_DIR
    public boolean uploadFile(MultipartFile multipartFile){
        boolean upload=false;//file not uploaded yet
        try {
            //multi
            InputStream inputStream=multipartFile.getInputStream();
            //read and store in data array
            byte data[]=new byte[inputStream.available()];
            inputStream.read(data); //fills data
            //write on folder
            FileOutputStream fileOutputStream=new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
            upload=true;
            //other way using nio package
            /*
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING); //here path is required so paths.get is sed to convert string(UPLOAD_DIR) to path
             */
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return upload;
    }


}
