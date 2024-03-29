package sp.zyy.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import sp.zyy.common.BaseEntity;

/**
  * 类名：RoleEntity.java
  * 类说明： 
  * Copyright: Copyright (c) 2012-2019
  * Company: HT
  * @author     shipeng
  * @date       2019年6月25日
  * @version    1.0
*/
@Entity
@Table(
        name = "role")
public class RoleEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6402267170521440022L;

    @Column(
            length = 50, nullable = false)
    private String name;

    @Column(
            length = 50, nullable = false)
    private String password;

    @Column(
            length = 50, nullable = false)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
