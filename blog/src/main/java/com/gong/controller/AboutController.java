package com.gong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CodeSniper
 * @since 2021-07-18
 */

@Controller
public class AboutController {

    @RequestMapping("/about")
    public String showAbout(){
        return "/about";
    }
}
