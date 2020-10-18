package com.zengande.dianping.service.impl;

import com.zengande.dianping.commom.BusinessException;
import com.zengande.dianping.commom.ResultStateCode;
import com.zengande.dianping.dao.AccountMapper;
import com.zengande.dianping.entity.Account;
import com.zengande.dianping.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account getAccountById(Integer id) throws BusinessException {
        Account account = accountMapper.selectByPrimaryKey(id);
        if(account == null){
            throw new BusinessException(ResultStateCode.REQUEST_OBJECT_NOTFOUND);
        }
        return  account;
    }
}
