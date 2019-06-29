package sp.zyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sp.zyy.entity.RoleEntity;
import sp.zyy.repo.RoleRepo;
import sp.zyy.service.RoleService;

/**
  * 类名：RoleServiceImpl.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return roleRepo.save(roleEntity);
    }

    /** 
      * 方法：getByName 
      * @see sp.zyy.service.RoleService#getByName(java.lang.String)
      * 方法说明： 
      * @author     shipeng
      * @date       2019年6月25日
     */
    @Override
    public int count(String name) {

        return roleRepo.count(name);
    }

    /** 
      * 方法：getRoleByName 
      * @see sp.zyy.service.RoleService#getRoleByName(java.lang.String)
      * 方法说明： 
      * @author     shipeng
      * @date       2019年6月29日
     */
    @Override
    public RoleEntity getRoleByName(String name) {
        return roleRepo.getRoleByName(name);
    }

}
