package net.obcy.bookrental.service;

import net.obcy.bookrental.model.User;
import net.obcy.bookrental.model.request.UserRegisterRequest;
import net.obcy.bookrental.model.response.UserLoginResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    boolean existsByEmailAddress(String emailAddress);

    User findByEmailAddress(String emailAddress);

    void save(User user);

    User registerUser(UserRegisterRequest userRegisterRequest);

    UserLoginResponse getUserLoginResponse(String emailAddress);

    Page<User> findAll(Pageable pageable);
}
