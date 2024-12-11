package com.ohgiraffers.thymeleaf;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {
    private String name;
    private int age;
    private String gender;
    private String address;
}
