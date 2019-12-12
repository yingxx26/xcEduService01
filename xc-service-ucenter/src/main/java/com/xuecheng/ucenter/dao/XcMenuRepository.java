package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface XcMenuRepository extends JpaRepository<XcMenu,String> {
    //根据账号查询用户信息
    //XcUser findByUsername(String username);
}
