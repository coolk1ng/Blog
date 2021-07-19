package com.gong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by GongXiWu on 2021/05/25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private Integer id;

    //昵称
    private String nickname;

    //邮箱
    private String email;

    //头像
    private String avatar;

    //评论内容
    private String content;

    //创建时间
    private Date createTime;

    //博客id
    private Integer blogId;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();

    //父评论id
    private Integer parentCommentId;

    private boolean adminComment;


}
