package com.example.backend.controllers;

import com.example.backend.entity.Files;
import com.example.backend.entity.ResponseBase;
import com.example.backend.entity.userInfo.adminUserInfoRequest;
import com.example.backend.services.AccessService;
import com.example.backend.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {



    @Autowired
    private FileService fileService;

    @Autowired
    private AccessService accessService;

    @PostMapping("/loadFile")
    public ResponseBase loadFile(@RequestBody adminUserInfoRequest request) {
        System.out.println("[loadFile] receive");
        ResponseBase res = new ResponseBase();
        try {
            String accessToken = request.getAccessToken();
            int userId = accessService.getAuthenticatedId(accessToken);
            List<Files> records = fileService.getFileByUserId(userId);
            for (Files record : records) {
                res.pushData(record);
            }
        }
        catch (Exception e) {
            res.setStatus(-1);
            res.setMessage(e.getMessage());
        }
        return res;
    }

    @PostMapping("/moveFile")
    public ResponseEntity<ResponseBase> moveFile(@RequestBody Files record) {
        ResponseBase response = new ResponseBase();
        int res_code = fileService.moveFile(record);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/delFile")
    public ResponseEntity<ResponseBase> delFile(@RequestBody Files record) {
        ResponseBase response = new ResponseBase();
        int res_code = fileService.delFolder(record);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/remarkFile")
    public ResponseEntity<ResponseBase> remarkFile(@RequestBody Files record) {
        ResponseBase response = new ResponseBase();
        int res_code = fileService.remarkFile(record);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/uploadFile")
    public ResponseEntity<ResponseBase> uploadFile(@RequestBody Files record) {
        ResponseBase response = new ResponseBase();
        System.out.println(record);
        System.out.println(record.getFileName());
        int res_code = fileService.uploadFile(record);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }//写错的


    @PostMapping("/upload")
    public ResponseEntity<ResponseBase> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("folder_id") String folderId,  // 接收 folder_id
            @RequestParam("user") String user) {        // 接收 user
        ResponseBase response = new ResponseBase();
        // 定义文件保存路径
        System.out.println(folderId);
        System.out.println(user);
        String uploadDir = "F:/upload/";  // 可以修改为你存储文件的目录
        String allFileName = file.getOriginalFilename();
        String filePath = uploadDir + allFileName;

        try {
            // 保存文件到服务器
            File targetFile = new File(filePath);
            file.transferTo(targetFile);

            // 生成文件的 URL
            String fileUrl = "http://localhost:8080/" + allFileName;  // 根据你实际的 URL 配置修改
            System.out.println(fileUrl);
            response.pushData(fileUrl);
            Files record = new Files();
            record.setFileName(allFileName);
            record.setFilePath(filePath);
            int dotIndex = allFileName.lastIndexOf('.');

            // 分离文件名和扩展名
            String fileName = allFileName.substring(0, dotIndex);
            String ext = allFileName.substring(dotIndex + 1);
            System.out.println(fileName);
            System.out.println(ext);
            record.setUrl(fileUrl);
            record.setUserId(user);
            record.setDirId(Integer.valueOf(folderId));
            record.setExt(ext);
            record.setSize(String.valueOf(file.getSize()));
            System.out.println(file.getSize());
            System.out.println(record);

            int res_code = fileService.uploadFile(record);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (IOException e) {
            response.setMessage("上传失败");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }




}




