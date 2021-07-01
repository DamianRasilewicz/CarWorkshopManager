package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Role;
import java.util.List;


@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleById(Integer id);

    Role findRoleByName(String name);

    @Query(value = "SELECT * FROM car_worksop_manager.roles",nativeQuery = true)
    List<Role> findAllRoles();

}
