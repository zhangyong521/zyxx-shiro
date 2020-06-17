package com.zyxx.fileserver.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件 接口
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface FileServerService {

    String upload(MultipartFile file, String folder);

    String uploadMore(MultipartFile[] files, String folder);

    String uploadByThumbnail(MultipartFile[] files, String folder, boolean saveOld);

    String folderToZip(String folderPath, String zipPath, String fileName);

    String createQrCode(String content, String folder);

    void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response);
}
