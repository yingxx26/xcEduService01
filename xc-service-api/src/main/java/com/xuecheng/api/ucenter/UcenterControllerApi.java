package com.xuecheng.api.ucenter;

import com.xuecheng.framework.domain.ucenter.User;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.model.response.QueryOneResponseResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator.
 */
@Api(value = "用户中心",description = "用户中心管理")
public interface UcenterControllerApi {
    @ApiOperation("根据用户账号查询用户信息")
    public XcUserExt getUserext(String username);

    @ApiOperation("查询用户list")
    public QueryResponseResult<User> findUserList( int page,  int size );

    @ApiOperation("添加用户")
    public ResponseResult addUser (  User user  );
    @ApiOperation("删除用户")
    public ResponseResult delUser ( String id  ) ;
    @ApiOperation("获取用户")
    public QueryOneResponseResult getUser(String id) ;
    @ApiOperation("修改用户")
    public QueryOneResponseResult edit(  User user) ;
}
