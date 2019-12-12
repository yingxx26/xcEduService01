package com.xuecheng.framework.domain.ucenter;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by admin on 2018/3/19.
 */
@Data
@ToString
@Entity
@Table(name="xc_role")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcRole {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name="roleName")
    private String role_name;
    @Column(name="roleCode")
    private String role_code;
    private String description;
    private String status;
    @Column(name="createTime")
    private Date create_time;
    @Column(name="updateTime")
    private Date update_time;


}
