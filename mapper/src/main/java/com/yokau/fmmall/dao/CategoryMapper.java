package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.Category;
import com.yokau.fmmall.general.GeneralDao;
import com.yokau.fmmall.entity.CategoryVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper extends GeneralDao<Category> {
    // 1. 连接查询
    List<CategoryVO> selectAllCategories();
    // 2. 子查询：根据parentId查询子分类
    List<CategoryVO> selectAllCategoriesTwo(Integer parentId);
}