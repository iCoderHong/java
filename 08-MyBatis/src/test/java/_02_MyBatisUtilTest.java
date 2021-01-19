import com.ch.domain.Student;
import com.ch.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class _02_MyBatisUtilTest {
    @Test
    public void testSelectAllStudents() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        List<Student> students = sqlSession.selectList("selectAllStudents");
        students.forEach((e) -> {
            System.out.println(e);
        });
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testUpdateStudent() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        Student student = new Student(31, "Jack", 10);
        int row = sqlSession.update("updateStudent", student);
        sqlSession.commit();
    }

    @Test
    public void testInsertStudent() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Andy");
        map.put("age", 40);
        sqlSession.insert("insertStudent", map);
        sqlSession.commit();
    }

    @Test
    public void testDeleteStudentById() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        sqlSession.delete("deleteStudentById", 30);
        sqlSession.commit();
    }
}
