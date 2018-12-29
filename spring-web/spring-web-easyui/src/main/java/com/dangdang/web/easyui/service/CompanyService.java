package com.dangdang.web.easyui.service;

import com.dangdang.web.easyui.entity.Company;

import java.util.List;

/**
 * 公司信息先关的操作
 */
public interface CompanyService {


    /**
     * 修改公司信息
     * @param company
     * @return
     */
    public Company modifyCompany(Company company);

    /**
     * 查询公司信息
     * @return
     */
    public List<Company> findAll();


}
