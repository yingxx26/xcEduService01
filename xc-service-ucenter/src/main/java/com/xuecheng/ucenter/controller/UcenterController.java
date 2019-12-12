package com.xuecheng.ucenter.controller;

import com.xuecheng.api.ucenter.UcenterControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.model.response.QueryOneResponseResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.utils.XcOauth2Util;
import com.xuecheng.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/ucenter")
public class UcenterController implements UcenterControllerApi {
    @Autowired
    UserService userService;

    @Override
    @GetMapping("/getuserext")
    public XcUserExt getUserext(@RequestParam("username") String username) {
        return userService.getUserExt(username);
    }

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<User> findUserList(@PathVariable("page") int page,
                                                    @PathVariable("size") int size ) {

        QueryResponseResult<User> userList = userService.findUserList(page, size);
        return userList;
    }
    @Override
    @PostMapping("/add")
    public ResponseResult addUser (@RequestBody User user  ) {

     return  userService.addUser(user);
    }

    @Override
    @DeleteMapping("/del/{id}")
    public ResponseResult delUser (@PathVariable("id") String id  ) {
      User user=new User();
      user.setId(id);
        return  userService.delUser(user);
    }

    @Override
    @GetMapping("/get/{id}")
    public QueryOneResponseResult getUser(@PathVariable("id") String id) {
        QueryOneResponseResult user = userService.getUser(id);
        return user;
    }

    @Override
    @PutMapping("/edit")//这里使用put方法，http 方法中put表示更新
    public QueryOneResponseResult edit(  @RequestBody User user) {

        QueryOneResponseResult result = userService.update( user);
        return result;
    }

}
