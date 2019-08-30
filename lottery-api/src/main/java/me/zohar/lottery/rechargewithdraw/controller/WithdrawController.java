package me.zohar.lottery.rechargewithdraw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelWithdrawRecordQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;
import me.zohar.lottery.rechargewithdraw.service.WithdrawService;

@Controller
@RequestMapping("/withdraw")
public class WithdrawController {

	@Autowired
	private WithdrawService withdrawService;

	@PostMapping("/startWithdraw")
	@ResponseBody
	public Result startWithdraw(@RequestBody StartWithdrawParam param) {
		withdrawService.startWithdraw(param);
		return Result.success();
	}

	@PostMapping("/findLowerLevelWithdrawRecordByPage")
	@ResponseBody
	public Result findLowerLevelWithdrawRecordByPage(@RequestBody LowerLevelWithdrawRecordQueryCondParam param) {
		return Result.success().setData(withdrawService.findLowerLevelWithdrawRecordByPage(param));
	}

}
