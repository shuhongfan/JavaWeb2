package com.shf.test;

import com.shf.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        User user = new User();
        BeanUtils.setProperty(user,"username","zhangsan");
        System.out.println(user);

        String gender = BeanUtils.getProperty(user, "username");
        System.out.println(gender);
    }
}
