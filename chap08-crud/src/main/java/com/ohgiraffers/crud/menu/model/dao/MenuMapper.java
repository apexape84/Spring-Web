package com.ohgiraffers.crud.menu.model.dao;

import com.ohgiraffers.crud.menu.model.dto.MenuAndCategoryDTO;
import com.ohgiraffers.crud.menu.model.dto.MenuDTO;
import com.ohgiraffers.crud.menu.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper // MyBatis전용 어노테이션, Repository의 더 구체적인 기능을 가짐
public interface MenuMapper {

    List<MenuDTO> findAllMenus();

    List<CategoryDTO> findAllCategory();

    @Transactional  // DML작업을 하나로 묶은 트랜잭션 관리 어노테이션
    // 내부적으로 AOP기능을 사용하고 있음. commit rollback을 자동으로 해서 데이터 일관성 관리
    void registNewmenu(MenuDTO newMenu);

    List<MenuAndCategoryDTO> findAllMenuAndCategory();
}
