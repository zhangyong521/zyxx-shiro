package com.zyxx.system.service.impl;

import com.zyxx.common.authorization.ShiroUtils;
import com.zyxx.common.consts.SessionConst;
import com.zyxx.common.entity.LayuiTable;
import com.zyxx.common.entity.UserInfoSession;
import com.zyxx.common.enums.StatusEnums;
import com.zyxx.common.exception.CrudException;
import com.zyxx.fileserver.entity.RequestFileServerPath;
import com.zyxx.system.entity.MapUserRole;
import com.zyxx.system.entity.ResourceInfo;
import com.zyxx.system.entity.RoleInfo;
import com.zyxx.system.entity.UserInfo;
import com.zyxx.system.mapper.ResourceInfoMapper;
import com.zyxx.system.mapper.RoleInfoMapper;
import com.zyxx.system.mapper.UserInfoMapper;
import com.zyxx.system.service.MapUserRoleService;
import com.zyxx.system.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户表 Service接口实现类
 *
 * @author Tellsea
 * @date 2020-03-04
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private MapUserRoleService mapUserRoleService;
    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public UserInfo getByUserName(String userName) {
        return baseMapper.selectOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getUserName, userName));
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return this.baseMapper.getUserInfoById(id);
    }

    @Override
    public LayuiTable listUserInfoByTable(UserInfo userInfo) {
        return LayuiTable.build(this.baseMapper.countUserInfoByTable(userInfo), this.baseMapper.listUserInfoByTable(userInfo));
    }

    @Override
    public int saveUserInfo(UserInfo userInfo) throws CrudException {
        int count = this.baseMapper.insert(userInfo);
        if (count == 0) {
            throw new CrudException(StatusEnums.SAVE_ERROR.getInfo());
        }
        saveMapUserRole(userInfo);
        return count;
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) throws CrudException {
        int count = this.baseMapper.updateById(userInfo);
        if (count != 1) {
            throw new CrudException(StatusEnums.UPDATE_ERROR.getInfo());
        }
        mapUserRoleService.remove(new LambdaUpdateWrapper<MapUserRole>().eq(MapUserRole::getUserId, userInfo.getId()));
        saveMapUserRole(userInfo);
        return count;
    }

    private void saveMapUserRole(UserInfo userInfo) {
        String[] split = userInfo.getRoleIds().split(",");
        List<MapUserRole> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(new MapUserRole().setUserId(userInfo.getId()).setRoleId(Integer.valueOf(split[i])));
        }
        mapUserRoleService.saveBatch(list);
    }

    @Override
    public int updateStatus(UserInfo userInfo) throws CrudException {
        int count = this.baseMapper.updateById(userInfo);
        if (count == 0) {
            throw new CrudException(StatusEnums.DELETE_ERROR.getInfo());
        }
        return count;
    }

    @Override
    public void saveSession(String userName) {
        UserInfo userInfo = getByUserName(userName);
        List<RoleInfo> roleInfoList = roleInfoMapper.listRoleInfoByUserId(userInfo.getId());
        List<ResourceInfo> resourceInfoList = resourceInfoMapper.listResourceInfoByUserId(userInfo.getId());
        UserInfoSession ui = new UserInfoSession();
        ui.setUserInfo(userInfo);
        ui.setRoleInfoList(roleInfoList);
        ui.setResourceInfoList(resourceInfoList);
        ShiroUtils.setSessionAttribute(SessionConst.USER_INFO_SESSION, ui);
        // 文件服务请求路径
        ShiroUtils.setSessionAttribute(SessionConst.FILE_SERVER, new RequestFileServerPath());
    }
}
