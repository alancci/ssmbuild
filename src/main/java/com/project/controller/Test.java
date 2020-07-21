package com.project.controller;

import com.project.pojo.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
    @RequestMapping("/hello")
    @ResponseBody
    public Books hello(){
        Books books = new Books();
        books.setBookName("hello");
        books.setBookID(1);
        books.setBookCounts(2);
        books.setDetail("haha");
        return books;
    }


}
