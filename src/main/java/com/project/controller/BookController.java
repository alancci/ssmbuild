package com.project.controller;

import com.alibaba.fastjson.JSONObject;
import com.project.pojo.Books;
import com.project.pojo.WebResultDto;
import com.project.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }



    /**
     * @Description 根据id更新书籍
     * @Author  haojiaxing
     * @Date   2020/7/21 11:17
     * @Param  [books]
     * @Return      com.project.pojo.WebResultDto
     * @Exception
     *
     **/
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public WebResultDto updateBookdto(Books books){
        System.out.println(books);
        int save = bookService.updateBook(books);
        WebResultDto dto = new WebResultDto();
        dto.success(save);
        return dto;
    }
    /**
     * @Description 添加一本书
     * @Author  haojiaxing
     * @Date   2020/7/21 11:29
     * @Param  [books]
     * @Return      com.project.pojo.WebResultDto
     * @Exception
     *
     **/

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public WebResultDto addBookdto(Books books){
        WebResultDto dto = new WebResultDto();
        System.out.println(books);
        int add = bookService.addBook(books);
        dto.success(add);
        return dto;
    }




    @RequestMapping("/updateBook")
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }





    @RequestMapping("/test")
    @ResponseBody
    public Books booktest(){
//        WebResultDto dto = new WebResultDto();
        Books book = new Books();
        book.setBookID(1);
        book.setBookName("123");
        book.setBookCounts(2);
        book.setDetail("hahha");
        JSONObject model = new JSONObject();
        model.put("book",book);
        return book;
    }


    @RequestMapping("/testdto")
    @ResponseBody
    public WebResultDto webdto() {
        WebResultDto dto = new WebResultDto();
        List<Books> booksList = bookService.queryAllBook();
        JSONObject model = new JSONObject();
         model.put("book",booksList);
        dto.success(model);
        return dto;
    }

}
