package com.gong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.pojo.Blog;
import com.gong.pojo.Type;
import com.gong.service.BlogService;
import com.gong.service.TypeService;
import com.gong.vo.FirstPageBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author CodeSniper
 * @since 2021-07-18
 */

@Controller
public class ShowTypesController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BlogService blogService;

    @RequestMapping("/types/{id}")
    public String showType(@PathVariable Integer id, Model model,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum){
        List<Type> types = typeService.getAllTypeAndBlog();
        System.out.println(types);
        //-1表示从首页点进来
        if (id== -1){
            id=types.get(0).getId();
        }
        PageHelper.startPage(pageNum,5);
        PageInfo<FirstPageBlog> page = new PageInfo<>(blogService.getByTypeId(id));
        PageInfo<Type> typePage = typeService.getPage(1, 5);
        model.addAttribute("typePage",typePage);
        model.addAttribute("types",types);
        model.addAttribute("page",page);
        model.addAttribute("activeTypeId",id);
        System.out.println(page.getList());
        return "types";
    }
}
