package com.xuecheng.framework.domain.ucenter.ext;

import com.xuecheng.framework.domain.ucenter.XcMenu;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2018/3/20.
 */
@Data
@ToString
public class XcMenuVo  {


    private String id;
    private String code;

    private String parId;
    private String menuName;
    private String url;
    private String isMenu;
    private Integer level;
    private Integer sort;
    private String status;
    private String icon;
    private Date createTime;
    private Date updateTime;

}
