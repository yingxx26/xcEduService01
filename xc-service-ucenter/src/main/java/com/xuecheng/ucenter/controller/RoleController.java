package com.xuecheng.ucenter.controller;

import com.xuecheng.api.ucenter.UcenterControllerApi;
import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.XcRole;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.model.response.QueryOneResponseResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.ucenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/role")
public class RoleController   {
    @Autowired
    UserService userService;



    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult<XcRole> findUserList(@PathVariable("page") int page,
                                                    @PathVariable("size") int size ) {

        QueryResponseResult<XcRole> roleList = userService.findRoleList (page, size);
        return roleList;
    }


}
