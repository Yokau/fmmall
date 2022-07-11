package com.yokau.fmmall.service;

import com.yokau.fmmall.vo.ResultVO;

public interface UserAddrService {
    ResultVO listAddrsByUid(int userId);
}
