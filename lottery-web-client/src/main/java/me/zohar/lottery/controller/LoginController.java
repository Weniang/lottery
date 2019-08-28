package me.zohar.lottery.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.Result;

@RestController
@FeignClient(name = "lottery-web")
public interface LoginController {

	@PostMapping("/login")
	Result login(@RequestParam("userName") String userName, @RequestParam("password") String password);

}
