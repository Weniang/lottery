package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;
import me.zohar.lottery.issue.param.LotteryHistoryParam;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface IssueApi {

	@GetMapping("/issue/findLatelyThe5TimeIssue")
	Result findLatelyThe5TimeIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getCurrentIssue")
	Result getCurrentIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getNextIssue")
	Result getNextIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/getLatelyIssue")
	Result getLatelyIssue(@RequestParam(value = "gameCode") String gameCode);

	@GetMapping("/issue/findTodayTrackingNumberIssue")
	Result findTodayTrackingNumberIssue(@RequestParam(value = "gameCode") String gameCode);

	@PostMapping("/issue/findLotteryHistory")
	Result findLotteryHistory(@RequestBody LotteryHistoryParam param);

}
