package me.zohar.lottery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.zohar.lottery.common.vo.Result;
import me.zohar.lottery.config.security.JwtTokenUtil;
import me.zohar.lottery.useraccount.service.LoginService;
import me.zohar.lottery.useraccount.service.UserAccountService;
import me.zohar.lottery.useraccount.vo.LoginAccountInfoVO;

@RestController
public class LoginController {
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(String userName, String password) {
		loginService.login(userName, password);
		LoginAccountInfoVO loginAccountInfo = userAccountService.getLoginAccountInfo(userName);
		String token = jwtTokenUtil.generateToken(loginAccountInfo);
		return Result.success().setData(token);
	}

}
