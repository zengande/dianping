package com.zengande.dianping.controller;

import com.zengande.dianping.commom.BusinessException;
import com.zengande.dianping.commom.ResultStateCode;
import com.zengande.dianping.commom.JsonResult;
import com.zengande.dianping.entity.Account;
import com.zengande.dianping.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public JsonResult get(@RequestParam(name = "id") Integer id) throws BusinessException {
        Account account = accountService.getAccountById(id);
        if(account == null){
            return JsonResult.fail(ResultStateCode.REQUEST_OBJECT_NOTFOUND);
        }
        return JsonResult.success(account);
    }
}
