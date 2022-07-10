package net.obcy.bookrental.repository;

import net.obcy.bookrental.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAddress(String emailAddress);

    boolean existsByEmailAddress(String emailAddress);

    Page<User> findAll(Pageable pageableble);

}
