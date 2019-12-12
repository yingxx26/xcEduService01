package com.xuecheng.ucenter.dao;

import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.XcUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator.
 */
public interface UserRepository extends JpaRepository<User,String> {
    //根据账号查询用户信息
    //XcUser findByUsername(String username);
}
