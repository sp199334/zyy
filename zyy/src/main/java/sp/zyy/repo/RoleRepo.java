package sp.zyy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sp.zyy.entity.RoleEntity;

/**
  * 类名：RoleRepo.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
public interface RoleRepo extends JpaRepository<RoleEntity, Long> {

    @Query("select count(*) from RoleEntity r where r.name =?1")
    int count(@Param("name") String name);

    /** 
      * 方法：getRoleByName 
      * 方法说明：    TODO
      * @param name
      * @return
      * @author     shipeng
      * @date       2019年6月29日
    */
    @Query("select r from RoleEntity r where r.name =?1")
    RoleEntity getRoleByName(@Param("name") String name);
}
