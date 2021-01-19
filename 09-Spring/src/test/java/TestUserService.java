import com.ch.service.impl.UserServiceImpl;
import com.ch.vo.Order;
import com.ch.domain.User;
import com.ch.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserService {
    @Test
    public void test2() {
        // 接口ApplicationContext 使用实现类ClassPathXmlApplicationContext创建容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // User user = (User)context.getBean("User");
        User user = context.getBean(User.class);
        System.out.println(user);
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Order order = context.getBean(Order.class);
        System.out.println(order);
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userService = (UserServiceImpl)context.getBean("UserService");
        userService.saveUser(new User());
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("User");
        System.out.println(user);
    }
}
