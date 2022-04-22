package com.yokau.tkmapper.dao;

import com.yokau.tkmapper.beans.Category;
import javafx.scene.chart.CategoryAxis;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryDaoTest {

    @Resource
    private CategoryDao categoryDao;

    @Test
    public void insertTest() {
//    private int categoryId;
//    private String categoryName;
//    private int categoryLevel;
//    private int parentId;
//    private String categoryIcon;
//    private String categorySlogan;
//    private String categoryPic;
//    private String categoryBgColor;
        Category category = new Category(0, "测试类别1", 1, 0, "01.jpg", "Hello World", "aaa.jpg", "black");
        //int i = categoryDao.insert(category);
        int i = categoryDao.insertUseGeneratedKeys(category);  // 会进行Id回填
        System.out.println(category.getCategoryId());
        assertEquals(i, 1);
    }

    @Test
    public void updateTest() {
        Category category = new Category(54, "测试类别12", 1, 0, "01.jpg", "Hello World", "aaa.jpg", "black");
        int i = categoryDao.updateByPrimaryKey(category);
//        根据自定义条件修改，Example example就是封装条件的
//        int i = categoryDao.deleteByExample(Example e);
        assertEquals(1, i);
    }

    @Test
    public void deleteTest() {
        int i = categoryDao.deleteByPrimaryKey(54);
//        根据自定义条件删除
//        int i = categoryDao.deleteByExample(Example e);
        assertEquals(1, i);
    }

    @Test
    public void selectAllTest() {
        //查询所有
        List<Category> categories = categoryDao.selectAll();
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void selectByPrimaryKeyTest() {
        Category category = categoryDao.selectByPrimaryKey(47);
        System.out.println(category);
    }

    @Test
    public void selectWithConditionTest() {
        //条件查询
        //1.创建一个Example对象，类别Category查询条件
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("categoryLevel", 1);
        criteria.andLike("categoryName", "%干%")
                .andEqualTo("categoryLevel", 1);
        List<Category> categories = categoryDao.selectByExample(example);
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    @Test
    public void selectPageTest() {
        //分页查询
        int pageNum = 2;
        int pageSize = 10;
        int start = (pageNum - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(start, pageSize);
        List<Category> categories = categoryDao.selectByRowBounds(new Category(), rowBounds);
        for (Category category : categories) {
            System.out.println(category);
        }
        //查询总记录数
        int i = categoryDao.selectCount(new Category());
        System.out.println("Record Count : " + i);
    }

    @Test
    public void selectPageAndConditionTest(){
        //带条件分页
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("categoryLevel", 1);

        int pageNum = 1;
        int pageSize = 3;
        int start = (pageNum - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(start, pageSize);

        List<Category> categories = categoryDao.selectByExampleAndRowBounds(example, rowBounds);
        for(Category category : categories){
            System.out.println(category);
        }

        //查询总记录数（满足条件）
        int i = categoryDao.selectCountByExample(example);
        System.out.println("SelectCountByExample : " + i);
    }

}