package com.zyxx.system.mapper;

import com.zyxx.system.entity.RoleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表 Mapper接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    List<RoleInfo> getByUserName(String userName);

    int countRoleInfoByTable(@Param("entity") RoleInfo roleInfo);

    List<RoleInfo> listRoleInfoByTable(@Param("entity") RoleInfo roleInfo);

    List<RoleInfo> listRoleInfoByUserId(int userId);
}
