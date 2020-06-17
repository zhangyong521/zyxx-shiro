package com.zyxx.system.mapper;

import com.zyxx.system.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 Mapper接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int countUserInfoByTable(@Param("entity") UserInfo userInfo);

    List<UserInfo> listUserInfoByTable(@Param("entity")UserInfo userInfo);

    UserInfo getUserInfoById(int id);
}
