package me.zohar.lottery.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.FeignConfiguration;

@FeignClient(name = "lottery-api", configuration = FeignConfiguration.class)
public interface GameApi {

	@GetMapping("/game/findAllOpenGame")
	Result findAllOpenGame();

	@GetMapping("/game/findGamePlayAndNumLocateByGameCode")
	Result findGamePlayAndNumLocateByGameCode(@RequestParam("gameCode") String gameCode);

	@GetMapping("/game/findAllGameCategory")
	Result findAllGameCategory();

	@GetMapping("/game/findAllGameSituation")
	Result findAllGameSituation();

	@GetMapping("/game/findGameSituationByGameCategoryId")
	Result findGameSituationByGameCategoryId(@RequestParam("gameCategoryId") String gameCategoryId);

	@GetMapping("/game/findGameByGameCode")
	Result findGameByGameCode(@RequestParam("gameCode") String gameCode);

}
