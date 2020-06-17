package com.zyxx.backup.exception;

import com.zyxx.common.exception.BaseException;

/**
 * 连接异常异常
 *
 * @author Tellsea
 * @date 2020/4/4
 */
public class ConnectionException extends BaseException {

    public ConnectionException() {
        super();
    }

    public ConnectionException(String message) {
        super(message);
    }
}
