package com.me.fluxstudy.service;

import com.me.fluxstudy.model.Website;

import java.util.List;

public interface WebsiteService {

    Website getById(Long id);

    List<Website> listByCondition(Website website);

    int insert(Website website);

    int insertByBatch(List<Website> websiteList);

    int updateById(Website website);

    int logicalDeleteById(Long id);

}