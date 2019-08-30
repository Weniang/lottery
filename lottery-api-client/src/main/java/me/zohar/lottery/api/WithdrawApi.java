package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelWithdrawRecordQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.StartWithdrawParam;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface WithdrawApi {
	
	@PostMapping("/withdraw/startWithdraw")
	Result startWithdraw(@RequestBody StartWithdrawParam param);
	
	@PostMapping("/withdraw/findLowerLevelWithdrawRecordByPage")
	Result findLowerLevelWithdrawRecordByPage(@RequestBody LowerLevelWithdrawRecordQueryCondParam param);

}
