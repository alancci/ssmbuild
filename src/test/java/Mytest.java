import com.project.pojo.Books;
import com.project.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Mytest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) applicationContext.getBean("BookServiceImpl");
        for (Books books:bookServiceImpl.queryAllBook()) {
            System.out.println(books);
        }

    }


}
