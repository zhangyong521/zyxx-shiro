package com.zyxx.common.entity;

import com.zyxx.system.entity.ResourceInfo;
import com.zyxx.system.entity.RoleInfo;
import com.zyxx.system.entity.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * session 保存实体
 *
 * @author Tellsea
 * @date 2020-5-31
 */
@Getter
@Setter
public class UserInfoSession implements Serializable {

    private UserInfo userInfo;

    private List<RoleInfo> roleInfoList;

    private List<ResourceInfo> resourceInfoList;
}
