package com.project.service.impl;

import com.project.dao.BookMapper;
import com.project.pojo.Books;
import com.project.service.BookService;

import java.util.List;
/**
 * @Description 方法(或接口)是
 * @Author  haojiaxing
 * @Date   2020/7/21 10:36
 **/
public class BookServiceImpl implements BookService {
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }

    public int deleteBookById(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(Integer id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
