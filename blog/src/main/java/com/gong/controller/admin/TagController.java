package com.gong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Tag;
import com.gong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by GongXiWu on 2021/05/28
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    //跳转到标签页(分页查询)
    @GetMapping("/tags")
    public String tags(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                       @RequestParam(value = "pageSize",defaultValue = "5") int pageSize,
                       Model model){
        PageInfo<Tag> page = tagService.getPage(pageNum, pageSize);
        model.addAttribute("page",page);
        return "admin/tags";
    }

    //跳转到新增页面
    @GetMapping("/tags/input")
    public String input(Model model){
        //判断tag的id是否为空 从而确定跳转页面
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    //新增标签(重定向到标签页面)
    @PostMapping("/tags")
    public String post(@Valid Tag tag, BindingResult result, RedirectAttributes redirectAttributes){
        if (tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","标签名已存在");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Integer integer = tagService.addTag(tag);
        if (integer==null){
            redirectAttributes.addFlashAttribute("message","新增失败");
        }else{
            redirectAttributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/tags";
    }

    //携带id跳转到更新页面
    @GetMapping("/tags/{id}/input")
    public String editInput(@PathVariable Integer id,Model model){
        model.addAttribute("tag",tagService.getTagById(id));
        return "admin/tags-input";
    }

    //更新标签
    @PostMapping("/tags/update")
    public String editPost(@Valid Tag tag,BindingResult result,RedirectAttributes redirectAttributes){
        if (tagService.getTagByName(tag.getName())!=null){
            result.rejectValue("name","nameError","标签已存在");
        }
        if (result.hasErrors()){
            return "admin/tags-input";
        }
        Integer integer = tagService.updateTag(tag);
        if (integer==null){
            redirectAttributes.addFlashAttribute("message","更新失败");
        }else{
            redirectAttributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/tags";
    }

    //删除标签
    @GetMapping("/tags/{id}/delete")
    public String deleteGet(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        Integer integer = tagService.deleteTag(id);
        if (integer==null){
            redirectAttributes.addFlashAttribute("message","删除失败");
        }else{
            redirectAttributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/admin/tags";
    }

}
