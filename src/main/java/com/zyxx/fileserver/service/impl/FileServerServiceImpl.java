package com.zyxx.fileserver.service.impl;

import com.zyxx.fileserver.consts.FileServerConst;
import com.zyxx.fileserver.enums.FileServerEnums;
import com.zyxx.fileserver.exception.FileServerException;
import com.zyxx.fileserver.service.FileServerService;
import com.zyxx.fileserver.util.FileServerUtils;
import com.zyxx.fileserver.util.QrCodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件 接口实现类
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Service
public class FileServerServiceImpl implements FileServerService {

    @Override
    public String upload(MultipartFile file, String folder) {
        if (file.isEmpty()) {
            throw new FileServerException(FileServerEnums.NOT_FOUND.getInfo());
        }
        return FileServerUtils.upload(file, folder).getRelativePath();
    }

    @Override
    public String uploadMore(MultipartFile[] files, String folder) {
        if (files.length == 0) {
            throw new FileServerException(FileServerEnums.NOT_FOUND.getInfo());
        }
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            list.add(FileServerUtils.upload(file, folder).getRelativePath());
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new FileServerException(FileServerEnums.SAVE_ERROR.getInfo());
        }
        return StringUtils.join(list, FileServerConst.SEPARATOR);
    }

    @Override
    public String uploadByThumbnail(MultipartFile[] files, String folder, boolean saveOld) {
        if (files.length == 0) {
            throw new FileServerException(FileServerEnums.NOT_FOUND.getInfo());
        }
        List<String> list = new ArrayList<>();
        for (MultipartFile file : files) {
            list.add(FileServerUtils.uploadByThumbnail(file, folder, saveOld).getRelativePath());
        }
        if (CollectionUtils.isEmpty(list)) {
            throw new FileServerException(FileServerEnums.SAVE_ERROR.getInfo());
        }
        return StringUtils.join(list, FileServerConst.SEPARATOR);
    }

    @Override
    public String folderToZip(String folderPath, String zipPath, String fileName) {
        boolean flag = FileServerUtils.folderToZip(folderPath, zipPath, fileName);
        if (flag) {
            return zipPath + File.separator + fileName + ".zip";
        }
        throw new FileServerException(FileServerEnums.FILE_ZIP_ERROR.getInfo());
    }

    @Override
    public String createQrCode(String content, String folder) {
        try {
            String datePath = FileServerUtils.getDatePath(folder, FileServerUtils.DATE_TYPE_SLASH);
            String fileName = String.valueOf(UUID.randomUUID()).concat(".jpg");
            // 详情查看工具类，功能非常强大
            QrCodeUtils.encode(content, null, FileServerConst.SAVE_POSITION + datePath, fileName, false);
            return datePath + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new FileServerException(FileServerEnums.QRCODE_CREATE_ERROR.getInfo());
        }
    }

    @Override
    public void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) {
        FileServerUtils.download(filePath, fileName, request, response);
    }
}
