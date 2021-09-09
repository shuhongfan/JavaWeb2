package com.shf.test;

import com.shf.domain.User;
import com.shf.domain.dao.UserDao;
import org.junit.Test;

public class UserTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("superbaby");
        loginUser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
