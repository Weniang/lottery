package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.rechargewithdraw.param.LowerLevelRechargeOrderQueryCondParam;
import me.zohar.lottery.rechargewithdraw.param.RechargeOrderParam;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface RechargeApi {

	@PostMapping("/recharge/generateRechargeOrder")
	Result generateRechargeOrder(@RequestBody RechargeOrderParam param);
	
	@PostMapping("/recharge/findLowerLevelRechargeOrderByPage")
	Result findLowerLevelRechargeOrderByPage(@RequestBody LowerLevelRechargeOrderQueryCondParam param);

}
