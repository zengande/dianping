package com.zengande.dianping.service;

import com.zengande.dianping.commom.BusinessException;
import com.zengande.dianping.entity.Account;


public interface AccountService {
    Account getAccountById(Integer id) throws BusinessException;
}
