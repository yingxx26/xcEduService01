package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.XcRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface XcRoleRepository extends JpaRepository<XcRole,String> {
    //根据账号查询用户信息
    //XcUser findByUsername(String username);
}
