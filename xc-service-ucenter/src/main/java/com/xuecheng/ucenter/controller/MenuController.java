package com.xuecheng.ucenter.controller;

import com.alibaba.fastjson.JSON;
import com.xuecheng.api.ucenter.UcenterControllerApi;
import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.XcMenu;
import com.xuecheng.framework.domain.ucenter.ext.XcMenuExt;
import com.xuecheng.framework.domain.ucenter.ext.XcMenuVo;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.model.response.QueryOneResponseResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.ucenter.dao.XcMenuRepository;
import com.xuecheng.ucenter.service.UserService;
import org.bson.json.JsonParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/menu")
public class MenuController   {
    @Autowired
    UserService userService;


    @GetMapping("/list")
    public  List<XcMenuExt>  getmenuList( ) {

        List<XcMenuExt>  xcMenuExt= userService.selectXcmenuList();

         String s = JSON.toJSON(xcMenuExt).toString();
        return xcMenuExt;

    }

    @PostMapping("/add")
    public ResponseResult addXcMenu (@RequestBody XcMenuVo xcMenuVo  ) {

        return userService.addXcmenu(xcMenuVo);
    }
    /*@Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<User> findUserList(@PathVariable("page") int page,
                                                    @PathVariable("size") int size ) {

        QueryResponseResult<User> userList = userService.findUserList(page, size);
        return userList;
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
*/
}
