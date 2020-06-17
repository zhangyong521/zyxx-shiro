package com.zyxx.fileserver.consts;

import com.zyxx.common.consts.BaseConst;

/**
 * 文件路径常量
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface FileServerConst {


    String FILE_LOCATION = "/fileserver-static";
    /**
     * 保存位置（当前项目运行的相对根路径）
     */
    String SAVE_POSITION = BaseConst.PROJECT_LOCATION + FILE_LOCATION;
    /**
     * 访问前缀
     */
    String ACCESS_PREFIX = "http://localhost:8080" + FILE_LOCATION;
    /**
     * 分隔符
     */
    String SEPARATOR = ",";

    String THUMBNAIL_SUFFIX = "_thumbnail";

    String THUMBNAIL_SEPARATOR = "|";
}
