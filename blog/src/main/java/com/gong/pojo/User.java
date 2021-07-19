package com.gong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


/**
 * Created by GongXiWu on 2021/05/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;

    //昵称
    private String nickname;

    //用户名
    private String username;

    //头像
    private String avatar;

    //密码
    private  String password;

    //邮箱
    private String email;

    //用户类型
    private Integer type;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;


}
