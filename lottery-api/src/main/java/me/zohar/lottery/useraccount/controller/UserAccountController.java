package me.zohar.lottery.useraccount.controller;

import me.zohar.lottery.useraccount.param.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.useraccount.service.LoginService;
import me.zohar.lottery.useraccount.service.UserAccountService;
import me.zohar.lottery.useraccount.vo.UserAccountInfoVO;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/findLoginLogByPage")
    @ResponseBody
    public Result findLoginLogByPage(@RequestBody LoginLogQueryCondParam param) {
        return Result.success().setData(loginService.findLoginLogByPage(param));
    }

    @PostMapping("/findAccountChangeLogByPage")
    @ResponseBody
    public Result findAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param) {
        return Result.success().setData(userAccountService.findAccountChangeLogByPage(param));
    }

    @GetMapping("/findUserAccountDetailsInfoById")
    @ResponseBody
    public Result findUserAccountDetailsInfoById(String userAccountId) {
        return Result.success().setData(userAccountService.findUserAccountDetailsInfoById(userAccountId));
    }

    @PostMapping("/findUserAccountDetailsInfoByPage")
    @ResponseBody
    public Result findUserAccountDetailsInfoByPage(@RequestBody UserAccountQueryCondParam param) {
        return Result.success().setData(userAccountService.findUserAccountDetailsInfoByPage(param));
    }

    @GetMapping("/modifyLoginPwd")
    @ResponseBody
    public Result modifyLoginPwd(String userAccountId, String newLoginPwd) {
        userAccountService.modifyLoginPwd(userAccountId, newLoginPwd);
        return Result.success();
    }

    @GetMapping("/modifyMoneyPwd")
    @ResponseBody
    public Result modifyMoneyPwd(String userAccountId, String newMoneyPwd) {
        userAccountService.modifyMoneyPwd(userAccountId, newMoneyPwd);
        return Result.success().setMsg("支付密码设置成功");
    }

    @PostMapping("/updateUserAccount")
    @ResponseBody
    public Result updateUserAccount(@RequestBody UserAccountEditParam param) {
        userAccountService.updateUserAccount(param);
        return Result.success();
    }

    @PostMapping("/updateUserAccountBasicInfo")
    @ResponseBody
    public Result updateUserAccountBasicInfo(@RequestBody UserAccountBasicInfoEditParam param) {
        userAccountService.updateUserAccountBasicInfo(param);
        return Result.success().setMsg("保存成功");
    }


    @GetMapping("/delUserAccount")
    @ResponseBody
    public Result delUserAccount(String userAccountId) {
        userAccountService.delUserAccount(userAccountId);
        return Result.success();
    }

    @PostMapping("/addUserAccount")
    @ResponseBody
    public Result addUserAccount(@RequestBody AddUserAccountParam param) {
        userAccountService.addUserAccount(param);
        return Result.success();
    }

    @GetMapping("/getLoginAccountInfo")
    @ResponseBody
    public Result getLoginAccountInfo(String userAccountId) {
        return Result.success().setData(userAccountService.getLoginAccountInfo(userAccountId));
    }

    @PostMapping("/bindBankInfo")
    @ResponseBody
    public Result bindBankInfo(@RequestBody BindBankInfoParam param) {
        userAccountService.bindBankInfo(param);
        return Result.success();
    }

    @GetMapping("/getBankInfo")
    @ResponseBody
    public Result getBankInfo(String userAccountId) {
        return Result.success().setData(userAccountService.getBankInfo(userAccountId));
    }

    @PostMapping("/modifyLoginPwd")
    @ResponseBody
    public Result modifyLoginPwd(@RequestBody ModifyLoginPwdParam param) {
        userAccountService.modifyLoginPwd(param);
        return Result.success().setMsg("重置登录密码成功");
    }

    @PostMapping("/modifyMoneyPwd")
    @ResponseBody
    public Result modifyMoneyPwd(@RequestBody ModifyMoneyPwdParam param) {
        userAccountService.modifyMoneyPwd(param);
        if (StringUtils.isEmpty(param.getOldMoneyPwd())) {
            return Result.success().setMsg("设置支付密码成功");
        } else {
            return Result.success().setMsg("重置支付密码成功");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody UserAccountRegisterParam param) {
        userAccountService.register(param);
        return Result.success();
    }

    @PostMapping("/appRegister")
    @ResponseBody
    public Result appRegister(@RequestBody UserAccountAppRegisterParam param) {
        userAccountService.appRegister(param);
        return Result.success().setMsg("注册成功");
    }

    @GetMapping("/getUserAccountInfo")
    @ResponseBody
    public Result getUserAccountInfo(String userAccountId) {
        UserAccountInfoVO userAccountInfo = userAccountService.getUserAccountInfo(userAccountId);
        return Result.success().setData(userAccountInfo);
    }

    @PostMapping("/findMyAccountChangeLogByPage")
    @ResponseBody
    public Result findMyAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param) {
        return Result.success().setData(userAccountService.findAccountChangeLogByPage(param));
    }

    @PostMapping("/findLowerLevelAccountChangeLogByPage")
    @ResponseBody
    public Result findLowerLevelAccountChangeLogByPage(@RequestBody LowerLevelAccountChangeLogQueryCondParam param) {
        return Result.success().setData(userAccountService.findLowerLevelAccountChangeLogByPage(param));
    }

}
