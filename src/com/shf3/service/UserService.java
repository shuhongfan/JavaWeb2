package com.shf3.service;

import com.shf3.domain.PageBean;
import com.shf3.domain.User;

import java.util.List;
import java.util.Map;

//用户管理的业务接口
public interface UserService {
//    查询所有用户信息
    public List<User> findAll();

//    登录方法
    public User login(User user);

//    保存用户信息
    public void addUser(User user);

//    删除用户
    public void deleteUser(String id);

    public User findUserById(String id);

    public void updateUser(User user);

    public void delSelectedUser(String[] uids);

//    分页
    PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition);
}
