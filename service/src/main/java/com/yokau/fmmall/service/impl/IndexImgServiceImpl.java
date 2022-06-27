package com.yokau.fmmall.service.impl;

import com.yokau.fmmall.dao.IndexImgMapper;
import com.yokau.fmmall.entity.IndexImg;

import com.yokau.fmmall.service.IndexImgService;
import com.yokau.fmmall.vo.ResStatus;
import com.yokau.fmmall.vo.ResultVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Resource
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        if (indexImgs.size() == 0) {
            return new ResultVO(ResStatus.NO,"fail", null);
        } else {
            return new ResultVO(ResStatus.OK,"success", indexImgs);
        }
    }
}
