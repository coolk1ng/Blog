package com.gong.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.pojo.Blog;
import com.gong.pojo.User;
import com.gong.service.BlogService;
import com.gong.service.TagService;
import com.gong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


/**
 * Created by GongXiWu on 2021/05/26
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    //分页查询
    @GetMapping("/blogs")
    public String blogs(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                        Model model) {
        PageInfo<Blog> page = blogService.getPage(pageNum, pageSize);
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("page", page);
        return "admin/blogs";
    }

    //跳转到新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("types", typeService.getAllType());
        model.addAttribute("tags", tagService.getAllTag());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String insert(Blog blog, RedirectAttributes redirectAttributes, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        //设置blog的type
        blog.setType(typeService.getTypeById(blog.getType().getId()));
        //设置blog的typeId
        blog.setTypeId(blog.getType().getId());
        //设置user
        blog.setUserId(blog.getUser().getId());
        Integer integer = blogService.addBlog(blog);
        if (integer == null) {
            redirectAttributes.addFlashAttribute("message", "新增失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Integer integer = blogService.deleteBlog(id);
        if (integer == null) {
            redirectAttributes.addFlashAttribute("message", "删除失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/blogs";
    }

    //跳转到修改博客页面
    @GetMapping("/blogs/{id}/input")
    public String updatePage(@PathVariable Integer id, Model model,HttpSession session) {
        //获得全部tag,type
        model.addAttribute("tags", tagService.getAllTag());
        model.addAttribute("types", typeService.getAllType());
        Blog blog = blogService.getBlogById(id);
        System.out.println(blog);
        blog.init();
        model.addAttribute("blog", blog);
        return "admin/blogs-input";
    }

    //修改博客
    @PostMapping("/blogs/{id}")
    public String update(@Valid Blog blog, RedirectAttributes redirectAttributes){
        Integer i = blogService.updateBlog(blog);
        if (i==0){
            redirectAttributes.addFlashAttribute("message","修改失败");
        }else{
            redirectAttributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/blogs";
    }

    //搜索博客
    @PostMapping("/blogs/search")
    public String search(Blog blog, Model model,
                         @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogService.searchBlog(blog);
        PageInfo<Blog> page = new PageInfo<>(blogs);
        System.out.println(page.getList());
        model.addAttribute("page", page);
        return "admin/blogs :: blogList";
    }

}
