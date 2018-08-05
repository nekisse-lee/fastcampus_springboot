package com.nekisse.shop.dto;

import lombok.*;


//
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    //필드 선언 .
    private  Long id;
    private String title;
    private String author;
    private String isbn;
    private int price;
}
