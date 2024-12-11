package com.ohgiraffers.requestmapping;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/order/*")
public class ClassMappingController {

    @GetMapping("/regist")
    public String registOrer(Model model) {
        model.addAttribute("message","GET방식 주문등록" );
        return "mappingResult";
    }

    @RequestMapping(value={"modify", "delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model) {
        model.addAttribute("message","POST방식 주문등록" );
        return "mappingResult";
    }
    @GetMapping("/detail/{orderNo}")
    public String detail(Model model, @PathVariable("orderNo") int no) {
        model.addAttribute("message",no+"번 주문상세" );
        return "mappingResult";
    }

}
