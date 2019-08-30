package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.information.param.LotteryInformationQueryCondParam;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface LotteryInformationApi {

	@GetMapping("/lotteryInformation/findInformationById")
	Result findInformationById(@RequestParam(value = "id") String id);

	@GetMapping("/lotteryInformation/findTop13Information")
	Result findTop13Information();

	@PostMapping("/lotteryInformation/findLotteryInformationByPage")
	Result findLotteryInformationByPage(@RequestBody LotteryInformationQueryCondParam param);

}
