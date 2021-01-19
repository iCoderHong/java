package com.aj.dao.imp;
import com.aj.dao.UserDao;
import com.aj.doman.User;
import com.aj.utils.JDBCPoolUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class UserDaoImp implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCPoolUtil.getDataSource());

    /*
    public boolean addUser(User user) {
        Connection con = null;
        PreparedStatement statement = null;
        try {
            con = JDBCUtil.getConnection();
            con.setAutoCommit(false); // 关闭自动提交/开启事务(默认只要执行一条语句就提交一次)
            String sql = "INSERT INTO USER values (NULL, ?, ?, ?);";
            statement = con.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, user.getAge());
            int rows = statement.executeUpdate();
            con.commit(); // 提交事务
            return rows > 0;
        } catch (Exception e) {
           if (con != null) {
               try {
                   con.rollback(); // 事务回滚
               } catch (SQLException e1) {
                   e1.printStackTrace();
               }
           }
           e.printStackTrace();
        } finally {
            JDBCUtil.close(con, statement);
        }
        return false;
    }
    */

    /*
    public User findUser(String name, String password) {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?;";
            statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer uid = resultSet.getInt("uid");
                String name = resultSet.getString("username");
                Integer sex = resultSet.getInt("sex");
                return new User(uid, name, null,  sex);
            }
        } catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback(); // 事务回滚
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.close(con, statement, resultSet);
        }
        return null;
    }
    */

    /*
    public List<User> findAll() {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            con = JDBCUtil.getConnection();
            statement = con.prepareStatement("SELECT * FROM user");
            resultSet = statement.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                Integer uid = resultSet.getInt("uid");
                String name = resultSet.getString("username");
                Integer sex = resultSet.getInt("sex");
                User user = new User(uid, name, null,  sex);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback(); // 事务回滚
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.close(con, statement, resultSet);
        }
        return null;
    }
    */

    public User findUser(String name, String password) {
        String sql = "SELECT * FROM user where name = ? AND password = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
        return list.size() > 0 ? list.get(0) : null;
    }

    public User findUser(String id) {
        String sql = "select * from user where id = ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class), id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public boolean addUser(User user) {
        String sql = "INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int row = template.update(sql,
            null, user.getName(), user.getGender(), user.getAge(),
            user.getAddress(), user.getQq(), user.getEmail(), user.getPassword()
        );
        return row == 1;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    public boolean deleteUser(String id) {
        String sql = "DELETE FROM user where id = ?";
        int update = template.update(sql, id);
        return update > 0;
    }

    public boolean updateUser(User user) {
        String sql = "update user set name=?, gender=?, age=?, address=?, qq=?, email=?, password=? where id = ?";
        int update = template.update(sql, user.getName(), user.getGender(), user.getAge(),
                user.getAddress(), user.getQq(), user.getEmail(), user.getPassword(),  user.getId());
        return update >= 1;
    }

    @Override
    public List<User> findUser(Integer currPage, Integer pageSize) {
        String sql = "select * from user limit ?, ?";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class), (currPage - 1) * pageSize, pageSize);
        return list;
    }

    @Override
    public Integer findUserCount() {
        String sql = "select count(*) from user";
        Long count = template.queryForObject(sql, Long.class);
        return count.intValue();
    }
}
