package sp.zyy.service;

import sp.zyy.entity.RoleEntity;

/**
  * 类名：RoleService.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
public interface RoleService {

    RoleEntity save(RoleEntity roleEntity);

    int count(String name);

    RoleEntity getRoleByName(String name);
}
