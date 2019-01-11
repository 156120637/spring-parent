package com.dangdang.service.biz.service.impl;


import com.dangdang.repository.mysql.mapper.easyui.entity.Company;
import com.dangdang.repository.mysql.mapper.easyui.entity.CompanyExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.CompanyMapper;
import com.dangdang.service.biz.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company modifyCompany(Company company) {
        try {
            companyMapper.updateByPrimaryKey(company);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("修改错误,请稍后重试");
        }
        return company;
    }

    @Override
    public List<Company> findAll() {

        List<Company> companies = null;
        try {
            companies = companyMapper.selectByExample(new CompanyExample());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询出错,请稍后重试");
        }
        return companies;
    }
}
