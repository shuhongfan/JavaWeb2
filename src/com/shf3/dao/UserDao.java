package com.shf3.dao;

import com.shf3.domain.User;

import java.util.List;
import java.util.Map;

//用户操作的DAO
public interface UserDao {
//    查询所有的用户
    public List<User> findAll();

//    查询用户的用户名和密码
    public User findUserByUsernameAndPassword(String username,String password);

    public void addUser(User user);

    public void deleteUser(int id);

    public User findById(int id);

    public void updateUser(User user);

    public int findTotalCount(Map<String, String[]> condition);

    public List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
