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
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private Integer id;

    @NotBlank(message = "不能为空")
    private String name;

    private List<Blog> blogs=new ArrayList<>();


}
