package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.CategoryMapper;
import com.yokau.fmmall.entity.CategoryVO;
import com.yokau.fmmall.service.CategoryService;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 查询分类列表（包含三个级别的分类）
     * @return
     */
    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(ResStatus.OK, "SUCCESS", categoryVOS);
    }

    /**
     * 查询所有一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    @Override
    public ResultVO listFirstLevelCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectFirstLevelCategories();
        ResultVO resultVO = new ResultVO(ResStatus.OK, "SUCCESS", categoryVOS);
        return resultVO;
    }
}
