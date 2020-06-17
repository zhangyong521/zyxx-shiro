package com.zyxx.fileserver.config;

import com.zyxx.fileserver.consts.FileServerConst;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 资源映射路径
 *
 * @author Tellsea
 * @date 2019/7/20
 */
@Configuration
public class FileServerConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FileServerConst.FILE_LOCATION + "/**")
                .addResourceLocations("file:" + FileServerConst.SAVE_POSITION + "/");
    }
}
