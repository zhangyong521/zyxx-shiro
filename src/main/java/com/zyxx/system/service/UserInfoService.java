package com.zyxx.system.service;

import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户表 Service接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface UserInfoService extends IService<UserInfo> {

    UserInfo getByUserName(String userName);

    UserInfo getUserInfoById(int id);

    LayuiTable listUserInfoByTable(UserInfo userInfo);

    int saveUserInfo(UserInfo userInfo) throws CrudException;

    int updateUserInfo(UserInfo userInfo) throws CrudException;

    int updateStatus(UserInfo userInfo) throws CrudException;

    void saveSession(String userName);
}
