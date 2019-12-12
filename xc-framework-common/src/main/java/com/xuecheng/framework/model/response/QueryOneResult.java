package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */
@Data
@ToString
public class QueryOneResult<T> {
    //数据列表
    private  T result;
}
