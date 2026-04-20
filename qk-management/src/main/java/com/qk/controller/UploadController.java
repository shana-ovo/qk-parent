package com.qk.controller;

import com.qk.common.Result;
import com.qk.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@Slf4j
@RestController
public class UploadController {

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        //获取原始文件后缀名
        String originalFilename = image.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //生成新的文件名
        String newName = suffixName + UUID.randomUUID();
        String url = aliyunOSSOperator.upload(image.getBytes(), newName);
        log.info("阿里云oss 文件上传url：{}",url);
        return Result.success(url);
    }

}
