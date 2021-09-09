package com.shf.domain.dao;

import com.shf.domain.User;
import com.shf.domain.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库的User表类
public class UserDao {
//    声明JDBCTemplate对象公用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

//    登录方法
    public User login(User loginUser){
        try {
            String sql="select * from user where username=? and password=?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
