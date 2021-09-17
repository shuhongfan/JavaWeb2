package com.shf6.service;

import com.shf6.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();

    public String findAllJson();
}
