package com.gong.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by GongXiWu on 2021/05/25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type {

    private Integer id;

    //名称
    @NotBlank(message = "不能为空")
    private String name;

    private List<Blog> blogs = new ArrayList<>();
}
