package com.project.service;

import com.project.pojo.Books;

import java.util.List;

public interface BookService {
    //增加一个Book
    int addBook(Books book);

    //根据id删除一个Book
    int deleteBookById(Integer id);

    //更新Book
    int updateBook(Books books);

    //根据id查询,返回一个Book
    Books queryBookById(Integer id);

    //查询全部Book,返回list集合
    List<Books> queryAllBook();
    //条件查询
    List<Books> queryBookByCriteria(Books books);
}
