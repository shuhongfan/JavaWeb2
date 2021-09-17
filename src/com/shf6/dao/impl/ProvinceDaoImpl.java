package com.shf6.dao.impl;

import com.shf3.util.JDBCUtils;
import com.shf6.dao.ProvinceDao;
import com.shf6.domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {
//    1.声明成员变量
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
//        1.定义sql
        String sql="select * from province";
//        2.执行sql
        List<Province> li = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return li;
    }
}
