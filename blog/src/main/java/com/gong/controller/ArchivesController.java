package com.gong.controller;

import com.gong.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author CodeSniper
 * @since 2021-07-18
 */

@Controller
public class ArchivesController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/archives")
    public String archives(Model model){
        model.addAttribute("archivesMap",blogService.archivesBlog());
        model.addAttribute("blogTotal",blogService.getBlogTotal());
        System.out.println(blogService.getBlogTotal());
        return "archives";
    }
}
