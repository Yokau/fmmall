package com.yokau.fmmall;

import com.yokau.fmmall.dao.ProductMapper;
import com.yokau.fmmall.entity.Product;
import com.yokau.fmmall.entity.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ProductImgTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void ProductImgTest(){
        List<ProductVO> list = productMapper.selectRecommendProducts();
        for(ProductVO productVO : list){
            System.out.println(productVO);
        }
    }

}
