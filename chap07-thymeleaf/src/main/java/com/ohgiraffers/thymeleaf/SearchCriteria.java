package com.ohgiraffers.thymeleaf;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SearchCriteria {
    private int startPage;
    private int endPage;
    private int currentPage;
}
