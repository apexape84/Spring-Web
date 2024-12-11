package com.ohgiraffers.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {
    @GetMapping("stopwatch")
    public String handelerMethod() throws InterruptedException {
        System.out.println("Controller의 핸들러 메소드 호출됨");

        Thread.sleep(2000);
        return "result";
    }
}
