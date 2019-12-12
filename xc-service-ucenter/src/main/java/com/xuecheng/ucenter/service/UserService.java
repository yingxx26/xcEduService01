package com.xuecheng.ucenter.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.ucenter.*;
import com.xuecheng.framework.domain.ucenter.ext.XcMenuExt;
import com.xuecheng.framework.domain.ucenter.ext.XcMenuVo;
import com.xuecheng.framework.domain.ucenter.ext.XcUserExt;
import com.xuecheng.framework.model.response.*;
import com.xuecheng.ucenter.dao.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class UserService {

    @Autowired
    XcUserRepository xcUserRepository;

    @Autowired
    XcCompanyUserRepository xcCompanyUserRepository;
    @Autowired
    XcRoleMapper xcRoleMapper;
    @Autowired
    XcMenuMapper xcMenuMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    XcMenuRepository xcMenuRepository;

    //根据账号查询xcUser信息
    public XcUser findXcUserByUsername(String username){
        return xcUserRepository.findByUsername(username);
    }

    //根据账号查询用户信息
    public XcUserExt getUserExt(String username){
        //根据账号查询xcUser信息
        XcUser xcUser = this.findXcUserByUsername(username);
        if(xcUser == null){
            return null;
        }
        //用户id
        String userId = xcUser.getId();
        //查询用户所有权限
        List<XcMenu> xcMenus = xcMenuMapper.selectPermissionByUserId(userId);

        //根据用户id查询用户所属公司id
        XcCompanyUser xcCompanyUser = xcCompanyUserRepository.findByUserId(userId);
        //取到用户的公司id
        String companyId = null;
        if(xcCompanyUser!=null){
            companyId = xcCompanyUser.getCompanyId();
        }
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(xcUser,xcUserExt);
        xcUserExt.setCompanyId(companyId);
        //设置权限
        xcUserExt.setPermissions(xcMenus);
        return xcUserExt;

    }


    //查询我的课程
    public QueryResponseResult<User> findUserList(int page, int size ) {

        //分页
        PageHelper.startPage(page, size);
        //调用dao
       Page<User> userListPage = userMapper.findUserList();
        // Page<User> userListPage =userRepository.);
        List<User> list = userListPage.getResult();
        long total = userListPage.getTotal();
        QueryResult<User> userQueryResult = new QueryResult<User>();
        userQueryResult.setList(list);
        userQueryResult.setTotal(total);
        return new QueryResponseResult<User>(CommonCode.SUCCESS,userQueryResult);
    }

    public ResponseResult addUser(User user  ) {

        userRepository.save(user);
        return new ResponseResult(CommonCode.SUCCESS);
    }


    public ResponseResult delUser(User user  ) {

        userRepository.delete(user);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public QueryOneResponseResult getUser( String userid  ) {

        Optional<User> user1 = userRepository.findById(userid);
        User user2 = user1.get();
        QueryOneResult<User> queryOneResult = new QueryOneResult<User>();
        queryOneResult.setResult(user2);
        return new QueryOneResponseResult<User>(CommonCode.SUCCESS,queryOneResult);

    }


    public QueryOneResponseResult update(  User user){
        //根据id从数据库查询页面信息
        User one = userRepository.findById(user.getId()).get();

        if(one!=null){
            //准备更新数据
            //设置要修改的数据
            //更新模板id
            one.setUsername(user.getUsername() );

            //提交修改
            userRepository.save(one);
            QueryOneResult<User> queryOneResult = new QueryOneResult<User>();
            queryOneResult.setResult(one);
            return new QueryOneResponseResult(CommonCode.SUCCESS,queryOneResult);
        }
        //修改失败
        return new QueryOneResponseResult(CommonCode.FAIL,null);

    }



    public  List<XcMenuExt> selectXcmenuList(  ) {


        //调用dao
        List<XcMenuExt>    xcMenuExt = xcMenuMapper.selectXcmenuList();


        return xcMenuExt;
    }


    public ResponseResult addXcmenu(XcMenuVo xcMenuVo  ) {

        XcMenu xcMenu=new XcMenu();
        xcMenu.setPId(xcMenuVo.getParId() );
        xcMenu.setCode(xcMenuVo.getCode());
        xcMenu.setMenuName(xcMenuVo.getMenuName());
        xcMenu.setStatus(xcMenuVo.getStatus());
        xcMenuRepository.save(xcMenu);
        return new ResponseResult(CommonCode.SUCCESS);
    }

    //查询我的课程
    public QueryResponseResult<XcRole> findRoleList(int page, int size ) {

        //分页
        PageHelper.startPage(page, size);
        //调用dao
        Page<XcRole> xcRoleListPage =xcRoleMapper.findXcRoleList();

        List<XcRole> list = xcRoleListPage.getResult();
        long total = xcRoleListPage.getTotal();
        QueryResult<XcRole> roleQueryResult = new QueryResult<XcRole>();
        roleQueryResult.setList(list);
        roleQueryResult.setTotal(total);
        return new QueryResponseResult<XcRole>(CommonCode.SUCCESS,roleQueryResult);
    }

}
