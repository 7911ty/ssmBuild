import com.lty.domain.Books;
import com.lty.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
        for (Books queryAllBook : bookServiceImpl.queryAllBooks()) {
            System.out.println(queryAllBook);
        }
    }
}
