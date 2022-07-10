package net.obcy.bookrental.repository;

import net.obcy.bookrental.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);


}
