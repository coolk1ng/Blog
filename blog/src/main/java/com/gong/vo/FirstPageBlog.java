package com.gong.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author CodeSniper
 * @since 2021-07-16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstPageBlog {
    //Blog
    private Integer id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private String description;

    //Type
    private String typeName;


    //User
    private String nickname;
    private String avatar;
}
