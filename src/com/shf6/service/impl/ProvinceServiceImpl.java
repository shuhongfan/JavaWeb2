package com.shf6.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shf6.dao.ProvinceDao;
import com.shf6.dao.impl.ProvinceDaoImpl;
import com.shf6.domain.Province;
import com.shf6.service.ProvinceService;
import com.shf6.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
//    声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

//    使用缓存
    @Override
    public String findAllJson() {
//        1.先从redis中查询数据
        Jedis jedis = JedisPoolUtils.getJedis();
        String province = jedis.get("province");
//        2.判断province是否为null
        if (province==null || province.length()==0){
//            redis没有数据
            System.out.println("redis中没有数据，查询数据库中");
//            2.从数据库中查询
            List<Province> ps = dao.findAll();
//            3.将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                province = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
//            4.将json存在redis
            jedis.set("province",province);
//            5.归还连接
            jedis.close();
        } else {
            System.out.println("redis中有数据，查询缓存...");
        }
        return province;
    }
}
