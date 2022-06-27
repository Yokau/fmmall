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

    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(ResStatus.OK, "success",categoryVOS);
    }
}
