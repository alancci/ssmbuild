import com.project.config.ApplicationConfig;
import com.project.pojo.Books;
import com.project.service.BookService;
import com.project.service.impl.BookServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.print.Book;


public class Mytest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) applicationContext.getBean("BookServiceImpl");
        for (Books books:bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }

    }
    @Test
    public void testquery(){
        ApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) applicationContext.getBean("BookServiceImpl");
//        BookService bookService = (BookService) context.getBean("getBookServiceImplConfig");
            Books book = new Books();
            book.setBookName("人");

        for (Books books:bookService.queryBookByCriteria(book)) {
            System.out.println(books);
        }

    }
    @Test
    public void  testconfig(){
        ApplicationContext  context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Books book = (Books) context.getBean("getBook");
        System.out.println(book.getBookName());

    }


}
