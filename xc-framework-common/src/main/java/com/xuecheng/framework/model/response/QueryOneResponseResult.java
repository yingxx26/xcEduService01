package com.xuecheng.framework.model.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryOneResponseResult<T> extends ResponseResult {

    QueryOneResult<T> queryOneResult;

    public QueryOneResponseResult(ResultCode resultCode, QueryOneResult queryOneResult){
        super(resultCode);
       this.queryOneResult = queryOneResult;
    }

}
