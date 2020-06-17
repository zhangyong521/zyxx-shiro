package com.zyxx.fileserver.exception;

import com.zyxx.common.exception.BaseException;

/**
 * 文件服务异常
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public class FileServerException extends BaseException {

    public FileServerException() {
        super();
    }

    public FileServerException(String message) {
        super(message);
    }
}
