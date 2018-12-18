package com.me.fluxstudy;

import com.me.fluxstudy.dao.WebsiteDao;
import com.me.fluxstudy.model.Website;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class WebsiteDaoTest {

    @Resource
    private WebsiteDao websiteDao;

    @Test
    public void testList(){
        int n=0;
        while (n++<200){
            try {
                Website website=new Website();
                List<String> nameList=new LinkedList<>();
                nameList.add("Google");
                nameList.add("淘宝");
                website.setNameList(nameList);
                List<Website> websites = websiteDao.listByCondition(website);
                System.out.println(websites);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
