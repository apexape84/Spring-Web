package com.ohgiraffers.crud.menu.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MenuDTO {
    private int code;
    private String name;
    private int price;
    private int categoryCode;
    private String orderableStatus;
}
