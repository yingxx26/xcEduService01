package com.xuecheng.ucenter.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.ext.XcMenuExt;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.ucenter.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void testPageHelper() {
        //查询第1页，每页显示10条记录
        QueryResponseResult<User> userList = userService.findUserList(1, 5);
        System.out.println(userList);
    }

    @Test
    public void testmenu() {
        //查询第1页，每页显示10条记录
      /*  QueryResponseResult<XcMenuExt> xcMenuExtQueryResponseResult = userService.selectXcmenuList();
        System.out.println(xcMenuExtQueryResponseResult);*/
    }
}
