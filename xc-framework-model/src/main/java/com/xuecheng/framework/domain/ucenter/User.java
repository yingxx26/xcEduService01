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
@Table(name="user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class User {

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String username;



}
