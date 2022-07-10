package net.obcy.bookrental.service.impl;

import net.obcy.bookrental.model.Role;
import net.obcy.bookrental.model.User;
import net.obcy.bookrental.model.request.UserRegisterRequest;
import net.obcy.bookrental.model.response.UserLoginResponse;
import net.obcy.bookrental.repository.RoleRepository;
import net.obcy.bookrental.repository.UserRepository;
import net.obcy.bookrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean existsByEmailAddress(String emailAddress) {
        return userRepository.existsByEmailAddress(emailAddress);
    }

    @Override
    public User findByEmailAddress(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public User registerUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setEmailAddress(userRegisterRequest.getEmailAddress());
        user.setPassword(userRegisterRequest.getPassword());
        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setRoles(getDefaultRoles());

        save(user);
        return user;

    }

    @Override
    public UserLoginResponse getUserLoginResponse(String emailAddress) {
        User user = findByEmailAddress(emailAddress);
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        userLoginResponse.setEmailAddress(user.getEmailAddress());
        userLoginResponse.setFirstName(user.getFirstName());
        userLoginResponse.setLastName(user.getLastName());
        return userLoginResponse;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    private List<Role> getDefaultRoles() {
        Role role = roleRepository.findByName("USER");
        return List.of(role);
    }

}
