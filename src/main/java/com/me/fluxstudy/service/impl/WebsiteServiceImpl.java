package com.me.fluxstudy.service.impl;

import com.me.fluxstudy.dao.WebsiteDao;
import com.me.fluxstudy.model.Website;
import com.me.fluxstudy.service.WebsiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WebsiteServiceImpl implements WebsiteService {

    @Resource
    private WebsiteDao websiteDao;

    @Override
    public Website getById(Long id){
        return websiteDao.getById(id);
    }

    @Override
    public List<Website> listByCondition(Website website){
        return websiteDao.listByCondition(website);
    }

    @Override
    public int insert(Website website){
        return websiteDao.insert(website);
    }

    @Override
    public int insertByBatch(List<Website> websiteList){
        return websiteDao.insertByBatch(websiteList);
    }


    @Override
    public int updateById(Website website){
        return websiteDao.updateById(website);
    }

    @Override
    public int logicalDeleteById(Long id){
        return websiteDao.logicalDeleteById(id);
    }

}