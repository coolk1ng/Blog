package com.gong.controller.admin;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Type;
import com.gong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by GongXiWu on 2021/05/26
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    //分页查询分类
    @GetMapping("/types")
    public String types(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                        @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                        Model model){
        PageInfo<Type> page = typeService.getPage(pageNum, pageSize);
        model.addAttribute("page",page);
        return "admin/types";
    }

    //跳转到新增页面
    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    //携带该id到修改页面
    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Integer id,Model model){
        model.addAttribute("type",typeService.getTypeById(id));
        return "admin/types-input";
    }

    //新增分类
    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes redirectAttributes){
        if (typeService.getTypeByName(type.getName())!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Integer integer = typeService.addType(type);
        if (integer == null){
            redirectAttributes.addFlashAttribute("message","新增失败");
        }else{
            redirectAttributes.addFlashAttribute("message","新增成功");
        }
        return "redirect:/admin/types";
    }

    //更新分类
    @PostMapping("/types/update")
    public String editPost(@Valid Type type, BindingResult result, RedirectAttributes redirectAttributes){
        if (typeService.getTypeByName(type.getName())!=null){
            result.rejectValue("name","nameError","该分类已存在");
        }
        if (result.hasErrors()){
            return "admin/types-input";
        }
        Integer integer = typeService.updateType(type);
        if (integer == null){
            redirectAttributes.addFlashAttribute("message","更新失败");
        }else{
            redirectAttributes.addFlashAttribute("message","更新成功");
        }
        return "redirect:/admin/types";
    }

    //删除分类
    @GetMapping("/types/{id}/delete")
    public String deleteGet(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        Integer integer = typeService.deleteType(id);
        if (integer==null){
            redirectAttributes.addFlashAttribute("message","删除失败");
        }else{
            redirectAttributes.addFlashAttribute("message","删除成功");
        }
        return "redirect:/admin/types";
    }

}
