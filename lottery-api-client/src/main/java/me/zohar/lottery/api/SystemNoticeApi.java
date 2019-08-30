package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface SystemNoticeApi {

	@GetMapping("/systemNotice/findTop5PublishedSystemNotice")
	Result findTop5PublishedSystemNotice();

}
