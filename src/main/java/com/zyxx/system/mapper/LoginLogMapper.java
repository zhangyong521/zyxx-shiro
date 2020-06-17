package com.zyxx.system.mapper;

import com.zyxx.system.entity.LoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Mapper接口
 *
 * @author Tellsea
 * @date 2020-03-29
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {

    int countByTable(@Param("entity") LoginLog loginLog);

    List<LoginLog> listByTable(@Param("entity")LoginLog loginLog);
}
