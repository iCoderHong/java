import com.ch.dao.StudentDao;
import com.ch.domain.Student;

import com.ch.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

// 方式一: 自己手动创建的StudentDao实现类
// studentDao = new StudentDaoImpl();

// 方式二: 利用MyBatis动态创建的接口的实现类
public class _03_StudentDaoTest {
    @Test
    public void testSelectAllStudents() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudents();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testInsertStudent() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        studentDao.insertStudent("Andy", 28);
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testUpdateStudent() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(37, "中国", 20);
        studentDao.updateStuden(student);
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }

    @Test
    public void testDeleteStudentById() throws IOException {
        SqlSession sqlSession = MyBatisUtil.getCurrentSqlSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        studentDao.deleteStudentById(37);
        sqlSession.commit();
        MyBatisUtil.close(sqlSession);
    }
}
