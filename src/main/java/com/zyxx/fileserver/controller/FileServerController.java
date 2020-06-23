package com.zyxx.fileserver.controller;

import com.zyxx.common.entity.ResponseResult;
import com.zyxx.fileserver.service.FileServerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 文件 控制器
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Api("文件操作")
@RestController
@RequestMapping("/fileserver")
public class FileServerController {

    @Autowired
    private FileServerService fileServerService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ResponseResult upload(@RequestParam("file") MultipartFile file,
                                 @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileServerService.upload(file, folder));
    }

    @ApiOperation("多文件上传")
    @PostMapping("/uploadMore")
    public ResponseResult uploadMore(@RequestParam("file") MultipartFile[] files,
                                     @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileServerService.uploadMore(files, folder));
    }

    @ApiOperation("图片上传并压缩")
    @PostMapping("/uploadByThumbnail")
    public ResponseResult uploadByThumbnail(@RequestParam("file") MultipartFile[] files,
                                            @RequestParam(value = "folder", defaultValue = "default") String folder,
                                            @RequestParam(value = "saveOld", defaultValue = "true") boolean saveOld) {
        return ResponseResult.success(fileServerService.uploadByThumbnail(files, folder, saveOld));
    }

    @ApiOperation("将指定文件夹打包为zip")
    @PostMapping("/folderToZip")
    public ResponseResult folderToZip(String folderPath, String zipPath, String fileName) {
        return ResponseResult.success(fileServerService.folderToZip(folderPath, zipPath, fileName));
    }

    @ApiOperation("生成二维码")
    @PostMapping("/createQrCode")
    public ResponseResult createQrCode(@RequestParam(value = "content", defaultValue = "默认二维码内容")String content,
                                       @RequestParam(value = "folder", defaultValue = "default") String folder) {
        return ResponseResult.success(fileServerService.createQrCode(content, folder));
    }

    @ApiOperation("下载文件")
    @PostMapping("/downloadFile")
    public void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        fileServerService.downloadFile(filePath, fileName, request, response);
    }
}
