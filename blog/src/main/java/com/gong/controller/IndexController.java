package com.gong.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.pojo.Type;
import com.gong.service.BlogService;
import com.gong.service.TagService;
import com.gong.service.TypeService;
import com.gong.vo.DetailedBlog;
import com.gong.vo.FirstPageBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * created by GongXiWu on 2021/05/21
 */

@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public String index(Model model,@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        model.addAttribute("page",blogService.getFirstPage(pageNum,pageSize));
        model.addAttribute("tags",tagService.getPage(pageNum,pageSize));
        model.addAttribute("recommends",blogService.getAllRecommendBlog());
        model.addAttribute("types",typeService.getPage(pageNum,pageSize));
        model.addAttribute("typePages",typeService.getAllTypeAndBlog());
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model,@RequestParam String query,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<FirstPageBlog> search = blogService.queryBlog(query);
        PageInfo<FirstPageBlog> searchPage = new PageInfo<>(search);
        model.addAttribute("searchPage",searchPage);
        model.addAttribute("query",query);
        System.out.println(searchPage.getList());
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Integer id,Model model){
        DetailedBlog blog = blogService.getDetailedBlog(id);
        model.addAttribute("blog",blog);
        System.out.println(blog);
        return "blog";
    }


}
