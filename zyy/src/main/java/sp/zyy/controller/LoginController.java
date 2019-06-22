package sp.zyy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sp.zyy.entity.RoleEntity;
import sp.zyy.repo.RoleRepo;

@Api("用户登录管理")
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private RoleRepo role;

	@ResponseBody
	@ApiOperation("用户登录接口")
	@RequestMapping(method = RequestMethod.POST)
	public String login(String name, String password) {
		
		return "SUCCESS";
	}

	@ResponseBody
	@ApiOperation("用户注册接口")
	@RequestMapping(value = "/registry", method = RequestMethod.POST)
	public RoleEntity save(RoleEntity roleEntity) {

		return role.save(roleEntity);
	}
}
