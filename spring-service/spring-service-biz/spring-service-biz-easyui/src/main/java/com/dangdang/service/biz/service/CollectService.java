package com.dangdang.service.biz.service;

import com.dangdang.repository.mysql.mapper.easyui.entity.Collect;

import java.util.List;

/**
 * 收藏相关的操作
 */
public interface CollectService {

    /**
     * 添加收藏
     * @param collect
     * @return
     */
    public Collect addCollect(Collect collect);

    /**
     * 查询当前用户的收藏信息
     * @param userid
     * @return
     */
    public List<Collect> findByUser(String userid);

    /**
     * 删除收藏
     * @param coid
     * @return
     */
    public void removeCollect(String coid);


}
