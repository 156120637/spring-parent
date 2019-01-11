package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Address;

import java.util.List;

/**
 * 收货地址相关的操作
 */
public interface AddressService {


    /**
     * 添加新的地址
     * @param address
     */
    public void addAddress(Address address);

    /**
     * 修改地址信息
     * @param address
     */
    public void modifyAddress(Address address);

    /**
     * 查询用户的地址信息
     * @param userid
     * @return
     */
    public List<Address> findByUserId(String userid);


    /**
     * 删除地址信息
     * @param adid
     */
    public void removeAddress(String adid);


}
