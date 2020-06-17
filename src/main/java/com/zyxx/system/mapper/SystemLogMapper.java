package com.zyxx.system.mapper;

import com.zyxx.system.entity.SystemLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统日志表 Mapper接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface SystemLogMapper extends BaseMapper<SystemLog> {

    int countSystemLogByTable(@Param("entity")SystemLog systemLog);

    List<SystemLog> listSystemLogByTable(@Param("entity")SystemLog systemLog);

}
