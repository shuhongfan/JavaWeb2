package com.shf3.dao.impl;

import com.shf3.dao.UserDao;
import com.shf3.domain.User;
import com.shf3.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
//        使用JDBC查询数据库
//        1.定义sql
        String sql="select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username,String password){
        try {
            String sql="select * from user where username=? and password=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
//        1.定义sql
        String sql="insert into user values(null,?,?,?,?,?,?,null,null)";
//        2.执行sql
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
//        1.定义sql
        String sql="delete from user where id=?";
//        2.执行sql
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
//        1.定义sql
        String sql="select * from user where id=?";
//        2.执行sql
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
//        1.定义模板初始化sql
        String sql="select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
//        2.遍历map
        Set<String> keySet = condition.keySet();
//        定义参数的集合
        ArrayList<Object> params = new ArrayList<>();
        for (String key:keySet){
            if ("currentPage".equals(key)||"rows".equals(key)) continue;
//            获取value
            String value = condition.get(key)[0];
//            判断value是否有值
            if (value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
//                添加?条件值
                params.add("%"+value+"%");
            }
        }
        sql=sb.toString();
        return template.queryForObject(sql,Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
//        2.遍历map
        Set<String> keySet = condition.keySet();
//        定义参数的集合
        ArrayList<Object> params = new ArrayList<>();
        for (String key:keySet){
            if ("currentPage".equals(key)||"rows".equals(key)) continue;
//            获取value
            String value = condition.get(key)[0];
//            判断value是否有值
            if (value!=null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
//                添加?条件值
                params.add("%"+value+"%");
            }
        }
//        添加分页查询
        sb.append(" limit ?,?");
//        添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql=sb.toString();
        return template.query(sql,new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}
