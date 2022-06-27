package com.yokau.fmmall;

import com.yokau.fmmall.dao.CategoryMapper;
import com.yokau.fmmall.entity.CategoryVO;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;



    @Test
    public void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        for (CategoryVO c1 : categoryVOS){
            System.out.println(c1);
            for (CategoryVO c2 : c1.getCategories()){
                System.out.println(c2);
                for (CategoryVO c3 : c2.getCategories()){
                    System.out.println(c3);
                }
            }
        }
    }

}
