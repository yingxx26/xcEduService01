package com.xuecheng.ucenter.dao;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.XcRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator.
 */
@Mapper
public interface XcRoleMapper {

   Page<XcRole> findXcRoleList();

}
