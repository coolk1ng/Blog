package com.gong.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CodeSniper
 * @since 2021-07-16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchBlog {

    private Integer id;
    private String title;
    private String content;
}
