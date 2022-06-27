package com.yokau.fmmall.dao;

import com.yokau.fmmall.entity.IndexImg;
import com.yokau.fmmall.general.GeneralDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneralDao<IndexImg> {
    List<IndexImg> listIndexImgs();
}