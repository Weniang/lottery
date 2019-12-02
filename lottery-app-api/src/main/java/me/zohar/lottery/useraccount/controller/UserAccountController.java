package me.zohar.lottery.useraccount.controller;

import me.zohar.lottery.ValidationGrop;
import me.zohar.lottery.useraccount.param.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.api.UserAccountApi;
import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.UserAccountDetails;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController {

    @Autowired
    private UserAccountApi userAccountApi;

    @PostMapping("/bindBankInfo")
    @ResponseBody
    public Result bindBankInfo(@RequestBody BindBankInfoParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setUserAccountId(user.getUserAccountId());
        return userAccountApi.bindBankInfo(param);
    }

    @GetMapping("/getBankInfo")
    @ResponseBody
    public Result getBankInfo() {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return userAccountApi.getBankInfo(user.getUserAccountId());
    }

    @PostMapping("/modifyLoginPwd")
    @ResponseBody
    public Result modifyLoginPwd(@RequestBody ModifyLoginPwdParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setUserAccountId(user.getUserAccountId());
        return userAccountApi.modifyLoginPwd(param);
    }

    @PostMapping("/modifyMoneyPwd")
    @ResponseBody
    public Result modifyMoneyPwd(@RequestBody ModifyMoneyPwdParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setUserAccountId(user.getUserAccountId());
        return userAccountApi.modifyMoneyPwd(param);
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody UserAccountRegisterParam param) {
        return userAccountApi.register(param);
    }

    @PostMapping("/appRegister")
    @ResponseBody
    public Result appRegister(@RequestBody @Validated(ValidationGrop.UserCheckSequence.class) UserAccountAppRegisterParam param, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.fail(bindingResult.getFieldError().getDefaultMessage());
        } else {
            return userAccountApi.appRegister(param);
        }
    }

    @PostMapping("/updateUserAccountBasicInfo")
    @ResponseBody
    public Result updateUserAccountBasicInfo(@RequestBody UserAccountBasicInfoEditParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setUserAccountId(user.getUserAccountId());
        return userAccountApi.updateUserAccountBasicInfo(param);
    }

    @GetMapping("/getUserAccountInfo")
    @ResponseBody
    public Result getUserAccountInfo() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if ("anonymousUser".equals(principal)) {
            return Result.success();
        }
        UserAccountDetails user = (UserAccountDetails) principal;
        return userAccountApi.getUserAccountInfo(user.getUserAccountId());
    }

    @PostMapping("/findMyAccountChangeLogByPage")
    @ResponseBody
    public Result findMyAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setUserAccountId(user.getUserAccountId());
        return userAccountApi.findMyAccountChangeLogByPage(param);
    }

    @PostMapping("/findLowerLevelAccountChangeLogByPage")
    @ResponseBody
    public Result findLowerLevelAccountChangeLogByPage(@RequestBody LowerLevelAccountChangeLogQueryCondParam param) {
        UserAccountDetails user = (UserAccountDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        param.setCurrentAccountId(user.getUserAccountId());
        return userAccountApi.findLowerLevelAccountChangeLogByPage(param);
    }

}
