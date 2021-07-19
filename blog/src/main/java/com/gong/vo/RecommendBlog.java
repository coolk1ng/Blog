package com.gong.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodeSniper
 * @since 2021-07-16
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecommendBlog {

    private Integer id;
    private String title;
    private String firstPicture;
    private boolean recommend;
}
