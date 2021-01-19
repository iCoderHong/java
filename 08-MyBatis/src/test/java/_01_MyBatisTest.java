import com.ch.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 自动提交
 *  sqlSessionFactory.openSession(true); true代表自动提交
 * 手动提交
 *  sqlSessionFactory.openSession(); 默认false
 *  sqlSession.commit();
 *  insert delete update默认都需要提交事务 调用sqlSession.commit();
 */
public class _01_MyBatisTest {
    @Test
    public void testSelectAllStudents() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<Student> students = sqlSession.selectList("selectAllStudents");
        sqlSession.close();
    }

    @Test
    public void testUpdateStudent() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession(true);
        Student student = new Student(31, "Jack", 10);
        int row = sqlSession.update("updateStudent", student);
        sqlSession.close();
    }

    @Test
    public void testInsertStudent() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Andy");
        map.put("age", 40);
        sqlSession.insert("insertStudent", map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteStudentById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("deleteStudentById", 30);
        sqlSession.commit();
        sqlSession.close();
    }
}
