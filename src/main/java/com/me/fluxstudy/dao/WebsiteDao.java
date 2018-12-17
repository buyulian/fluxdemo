package com.me.fluxstudy.dao;


import com.me.fluxstudy.model.Website;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 不语恋 on 2017/5/12.
 */
@Repository
public interface WebsiteDao {

    Website getById(@Param("id") Long id);

    List<Website> listByCondition(Website website);

    int insert(Website website);

    int insertByBatch(List<Website> websiteList);

    int updateById(Website website);

    int logicalDeleteById(@Param("id") Long id);

}
