package com.zyxx.system.service;

import com.zyxx.common.exception.CrudException;
import com.zyxx.system.entity.ResourceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 资源表 Service接口
 *
 * @author Tellsea
 * @date 2020-03-04
 */
public interface ResourceInfoService extends IService<ResourceInfo> {

    List<ResourceInfo> getByUserName(String userName);

    List<ResourceInfo> listResourceInfoByTree(ResourceInfo resourceInfo);

    int saveResourceInfo(ResourceInfo resourceInfo) throws CrudException;

    int updateResourceInfo(ResourceInfo resourceInfo) throws CrudException;

    int deleteResourceInfoById(int id) throws CrudException;

    List<ResourceInfo> listResourceInfoByUserId(int userId);
}
