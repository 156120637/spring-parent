package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Company;

import java.util.List;

public interface SystemService {

    /**
     * 查询所有
     * @return
     */
    public List<Company> findAll();

    /**
     * 查询一个
     * @param id
     * @return
     */
    public Company findById(String id);


    /**
     * 修改数据
     * @param company
     */
    public void modifyCompany(Company company);


}
