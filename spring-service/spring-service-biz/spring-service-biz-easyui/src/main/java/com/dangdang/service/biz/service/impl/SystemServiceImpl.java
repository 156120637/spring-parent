package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Company;
import com.dangdang.repository.mysql.mapper.easyui.entity.CompanyExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.CompanyMapper;
import com.dangdang.service.biz.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.dangdang.service.biz.service.SystemService;


@Service("systemService")
@Transactional
public class SystemServiceImpl implements SystemService {

    @Autowired
    private CompanyMapper companyMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Company> findAll() {

        List<Company> companies = null;
        try {
            CompanyExample example = new CompanyExample();
            companies = companyMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
        return companies;
    }

    @Override
    public Company findById(String id) {

        Company company = null;
        try {
            company = companyMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }

        return company;
    }

    @Override
    public void modifyCompany(Company company) {

        try {
            companyMapper.updateByPrimaryKeySelective(company);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络异常,请重试");
        }
    }
}
