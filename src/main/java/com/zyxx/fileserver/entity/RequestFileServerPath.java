package com.zyxx.fileserver.entity;

import com.zyxx.fileserver.consts.FileServerConst;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 图片服务请求路径
 *
 * @author Tellsea
 * @date 2020-6-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RequestFileServerPath {

    private String upload = "/fileserver/upload";
    private String uploadMore = "/fileserver/uploadMore";
    private String uploadByThumbnail = "/fileserver/uploadByThumbnail";
    private String folderToZip = "/fileserver/folderToZip";
    private String createQrCode = "/fileserver/createQrCode";
    private String downloadFile = "/fileserver/downloadFile";

    private String accessPrefix = FileServerConst.ACCESS_PREFIX;
}
