package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.useraccount.param.AccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.BindBankInfoParam;
import me.zohar.lottery.useraccount.param.LowerLevelAccountChangeLogQueryCondParam;
import me.zohar.lottery.useraccount.param.ModifyLoginPwdParam;
import me.zohar.lottery.useraccount.param.ModifyMoneyPwdParam;
import me.zohar.lottery.useraccount.param.UserAccountRegisterParam;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface UserAccountApi {
	
	
	@GetMapping("/userAccount/getLoginAccountInfo")
	Result getLoginAccountInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/bindBankInfo")
	Result bindBankInfo(@RequestBody BindBankInfoParam param);

	@GetMapping("/userAccount/getBankInfo")
	Result getBankInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/modifyLoginPwd")
	Result modifyLoginPwd(@RequestBody ModifyLoginPwdParam param);

	@PostMapping("/userAccount/modifyMoneyPwd")
	Result modifyMoneyPwd(@RequestBody ModifyMoneyPwdParam param);

	@PostMapping("/userAccount/register")
	Result register(@RequestBody UserAccountRegisterParam param);

	@GetMapping("/userAccount/getUserAccountInfo")
	Result getUserAccountInfo(@RequestParam(value = "userAccountId") String userAccountId);

	@PostMapping("/userAccount/findMyAccountChangeLogByPage")
	Result findMyAccountChangeLogByPage(@RequestBody AccountChangeLogQueryCondParam param);

	@PostMapping("/userAccount/findLowerLevelAccountChangeLogByPage")
	Result findLowerLevelAccountChangeLogByPage(@RequestBody LowerLevelAccountChangeLogQueryCondParam param);

}
