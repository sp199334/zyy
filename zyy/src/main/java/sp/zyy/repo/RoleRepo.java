package sp.zyy.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import sp.zyy.entity.RoleEntity;

public interface RoleRepo extends JpaRepository<RoleEntity, Long>, JpaSpecificationExecutor<RoleEntity>, Serializable {

}
