package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.FeignConfiguration;

@RestController
@FeignClient(name = "lottery-web", configuration = FeignConfiguration.class)
public interface LotteryInformationController {

	@GetMapping("/lotteryInformation/findTop13Information")
	Object findTop13Information();

}
