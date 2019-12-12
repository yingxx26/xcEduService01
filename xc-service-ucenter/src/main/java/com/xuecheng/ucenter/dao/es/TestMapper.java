package com.xuecheng.ucenter.dao.es;

import com.github.pagehelper.Page;
import com.xuecheng.framework.domain.ucenter.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Administrator.
 */
@Mapper
public interface TestMapper {

   Long testSql();

}
