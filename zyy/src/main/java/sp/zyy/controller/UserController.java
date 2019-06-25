package sp.zyy.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Autowired
    private RoleService roleService;

    // @ResponseBody
    // @ApiOperation("用户登录接口")
    // @RequestMapping(
    // value = "/login", method = RequestMethod.POST)
    // public String login(@ApiParam(
    // required = true, value = "用户名") @RequestParam String name,
    // @ApiParam(
    // required = true,
    // value = "用户密码") @RequestParam String password) {
    // // RoleEntity roleEntity =new RoleEntity();
    // // roleEntity.setName(name);
    // // Example<RoleEntity> example = Example.of(roleEntity);
    // // Optional<RoleEntity> findOne = roleService.findOne(example);
    // // System.out.println(findOne);
    // return "SUCCESS";
    // }

    @ResponseBody
    @ApiOperation("用户注册接口")
    @RequestMapping(
            value = "/registry", method = RequestMethod.POST)
    public ResponseEntity<RoleEntity> save(@ModelAttribute RoleDTO roleDto) {

        String name = roleDto.getName();
        int count = roleService.count(name);
        if (count == 1) {
            return ResponseEntity.ok(null);
        }
        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDto, roleEntity);
        return ResponseEntity.ok(roleService.save(roleEntity));
    }
}
