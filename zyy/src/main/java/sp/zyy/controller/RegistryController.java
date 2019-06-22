package sp.zyy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("用户注册管理")
@RestController
@RequestMapping("/registry")
public class RegistryController {

	@ApiOperation("用户登录接口")
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public String registry(String account, String password, String phoneNumber) {
		return "success";
	}
}
