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
public class Blog {

    private Integer id;

    //标题
    private String title;

    //内容
    private String content;

    //头像
    private String firstPicture;

    //标记
    private String flag;

    //浏览次数
    private Integer views;

    //标签
    private List<Tag> tags=new ArrayList<>();

    //赞赏开启
    private boolean appreciation;

    //版权开启
    private boolean shareStatement;

    //评论开启
    private boolean commentable;

    //发布
    private boolean published;

    //创建时间
    private Date createTime;

    //更新时间
    private Date updateTime;

    //推荐
    private boolean recommend;

    //描述
    private String description;

    //typeId
    private Integer typeId;

    //userId
    private Integer userId;

    //tagId
    private String tagIds;

    //博客类型
    private Type type;

    private User user;

    private Integer commentCount;

    private List<Comment> comments = new ArrayList<>();

    public void  init(){
        this.tagIds=tagsToIds(this.getTags());
    }

    private String tagsToIds(List<Tag> tags){
        if ((!tags.isEmpty())){
            StringBuffer ids = new StringBuffer();
            boolean flag=false;
            for (Tag tag : tags){
                if (flag){
                    ids.append(",");
                }else {
                    flag=true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        }else {
            return tagIds;
        }
    }



}
