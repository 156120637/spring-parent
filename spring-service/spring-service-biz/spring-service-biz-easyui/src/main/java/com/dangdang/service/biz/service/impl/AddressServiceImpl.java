package com.dangdang.service.biz.service.impl;

import com.dangdang.repository.mysql.mapper.easyui.entity.Address;
import com.dangdang.repository.mysql.mapper.easyui.entity.AddressExample;
import com.dangdang.repository.mysql.mapper.easyui.mapper.AddressMapper;
import com.dangdang.service.biz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void addAddress(Address address) {
        try {
            address.setAdid(UUID.randomUUID().toString());
            address.setAdcreate(new Date());
            address.setUserid("1");// 用户id 当前登录用户id
            addressMapper.insertSelective(address);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
    }

    @Override
    public void modifyAddress(Address address) {

        try {
            addressMapper.updateByPrimaryKeySelective(address);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }

    }

    @Override
    public List<Address> findByUserId(String userid) {

        List<Address> addresses = null;
        try {
            AddressExample example = new AddressExample();
            example.createCriteria().andUseridEqualTo(userid);
            addresses = addressMapper.selectByExample(example);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
        return addresses;
    }

    @Override
    public void removeAddress(String adid) {
        try {
            addressMapper.deleteByPrimaryKey(adid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("网络错误,请重试");
        }
    }
}
