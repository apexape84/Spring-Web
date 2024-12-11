package com.ohgiraffers.handlermethod;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/request/*")
public class RequestController {
    @GetMapping("regist")
    public void regist() {}

    @PostMapping("regist")
    public String registMenu(Model model, WebRequest request) {
        String menuName = request.getParameter("name");
        int menuPrice = Integer.parseInt(request.getParameter("price"));
        int categoryCode = Integer.parseInt(request.getParameter("categoryCode"));

        String message = menuName + "을(를) " + categoryCode + "번 카테고리에 " + menuPrice + " 원으로 등록했습니다.";
        model.addAttribute("message", message);

        return "regist/printResult";
    }

    @GetMapping("modify")
    public void modify(){}

    @PostMapping("modify")
    public String modify(Model model, @RequestParam String modifyName
            , @RequestParam String modifyPrice){
        String message = modifyName + "의 가격을 " + modifyPrice + "로 수정";

        model.addAttribute("message", message);
        return "request/printResult";
    }

    @GetMapping("search")
    public void search(){}
}
