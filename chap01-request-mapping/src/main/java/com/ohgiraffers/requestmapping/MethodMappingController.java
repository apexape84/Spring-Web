package com.ohgiraffers.requestmapping;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodMappingController {
    /* 1. 메소드 방식 미지정 */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {
        model.addAttribute("message","메뉴 등록");
        return "mappingResult";
    }

    @RequestMapping(value ="/menu/modify", method = RequestMethod.GET)
    public String modifyMenu(Model model) {
        model.addAttribute("message", "GET방식만 허용함");
        return "mappingResult";
    }

    @GetMapping("/menu/delete")
    public String getDeleteMenu(Model model) {
        model.addAttribute("message","GET방식 메뉴 삭제");
        return "mappingResult";
    }
    @PostMapping("/menu/delete")
    public String postDeleteMenu(Model model) {
        model.addAttribute("message","POST방식 메뉴 삭제");
        return "mappingResult";
    }
}
