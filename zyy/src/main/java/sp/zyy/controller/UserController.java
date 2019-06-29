package sp.zyy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import sp.zyy.common.ResultInfo;
import sp.zyy.dto.RoleDTO;
import sp.zyy.entity.RoleEntity;
import sp.zyy.service.RoleService;

/**
  * 类名：UserController.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
@Api("用户信息管理")
@RestController
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RoleService roleService;

    @ResponseBody
    @ApiOperation("用户登录接口")
    @RequestMapping(
            value = "/login", method = RequestMethod.POST)
    public ResponseEntity<ResultInfo<String>> login(@ApiParam(
            required = true, value = "用户名") @RequestParam String name,
            @ApiParam(required = true,value = "用户密码") @RequestParam String password) {
        ResultInfo<String> ri = new ResultInfo<String>();
        RoleEntity role = roleService.getRoleByName(name);
        if (null == role) {
            ri.setStatus("failed");
            ri.setMsg("用户名或密码错误");
            return new ResponseEntity<ResultInfo<String>>(ri, HttpStatus.OK);
        }
        if (!password.equals(role.getPassword())) {
            ri.setStatus("failed");
            ri.setMsg("用户名或密码错误");
            return new ResponseEntity<ResultInfo<String>>(ri, HttpStatus.OK);
        }
        ri.setStatus("success");
        ri.setMsg("登陆成功");
        return new ResponseEntity<ResultInfo<String>>(ri, HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation("用户注册接口")
    @RequestMapping(
            value = "/registry", method = RequestMethod.POST)
    public ResponseEntity<ResultInfo<RoleEntity>> save(
            @ModelAttribute RoleDTO roleDto) {
        ResultInfo<RoleEntity> ri = new ResultInfo<RoleEntity>();
        String name = roleDto.getName();
        int count = roleService.count(name);
        if (count == 1) {
            ri.setMsg("该账户已被注册");
            ri.setStatus("falied");
            logger.error("该账户已被注册");
            return new ResponseEntity<ResultInfo<RoleEntity>>(ri,
                    HttpStatus.OK);
        }
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDto, roleEntity);
        ri.setStatus("success");
        ri.setResult(roleService.save(roleEntity));
        return new ResponseEntity<ResultInfo<RoleEntity>>(ri, HttpStatus.OK);
    }
}
