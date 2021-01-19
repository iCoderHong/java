import com.ch.domain.Student;
import com.ch.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProjTest {

    /**
     * 打印Spring容器中的beanDefinitionNames
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(context.getBeanDefinitionCount());
        for (String name : beanDefinitionNames) {
            System.out.println(name);
            System.out.println(context.getBean(name).getClass().toString());
            System.out.println("========================");
        }
    }

    /**
     * insert
     */
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService)context.getBean("studentService");
        Student student = new Student("Rose", 20);
        int row = service.addStudent(student);
        System.out.println(row);
    }

    /**
     * select
     */
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService)context.getBean("studentService");
        List<Student> students = service.queryAllStudents();
        students.forEach((e) ->{
            System.out.println(e);
        });

    }
}
