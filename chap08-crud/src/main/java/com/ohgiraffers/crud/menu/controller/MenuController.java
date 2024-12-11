package com.ohgiraffers.crud.menu.controller;

import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import com.ohgiraffers.crud.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @GetMapping("list")
    public String findMenuList(Model model) {
        List<MenuDTO> menuList = menuService.findAllMenus();

        model.addAttribute("menuList", menuList);

        return "menu/list";
    }

    @GetMapping("regist")
    public void resistPage(){}

    @GetMapping(value="category", produces = "application/json; charset=UTF-8")
    @ResponseBody   // 뷰를 제외하고 data만 리턴함
    public List<CategoryDTO> findCategoryList(){
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registMenu(@ModelAttribute MenuDTO newMenu, RedirectAttributes rttr, Locale locale) {
        //@ModelAttribute : form 태그로 묶어서 넘어노는 값을 클래스 자욜형에 담는 어노테이션
        //RedirectAttributes : 리다이렉트시 저장할 값이 있으면 사용하는 객체
        //Locale : 지역정보

        logger.info("locale : {}",locale);
        logger.info("newMenu : {}",newMenu);
        // trace :상세한 디버깅 정보
        // debug : 개발 중 디버깅용 정보
        // info : 일반적인 실행정보
        // warn : 잠재적인 문제 경고
        // error : 실행중 발생한 오류
        menuService.regeistMenu(newMenu);
        rttr.addFlashAttribute("successMessage", messageSource
                .getMessage("regist", new Object[]{newMenu.getName(),newMenu.getPrice()}, locale));

        return "redirect:/menu/list";
    }
    @GetMapping("popup")
    public String popupMenu(@ModelAttribute MenuDTO newMenu) {
        return "menu/popup";
    }

    @GetMapping("join/list")
    public String menuAndCategoryList(Model model) {

        List<MenuAndCategoryDTO> joinList = menuService.findAllMenuAndCategory();

        model.addAttribute("joinList",joinList);

        return "menu/join";
    }
}