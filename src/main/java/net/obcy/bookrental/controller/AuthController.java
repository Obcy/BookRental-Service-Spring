package net.obcy.bookrental.controller;

import lombok.extern.slf4j.Slf4j;
import net.obcy.bookrental.model.Role;
import net.obcy.bookrental.model.User;
import net.obcy.bookrental.model.response.UserLoginResponse;
import net.obcy.bookrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/services/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<UserLoginResponse> getCurrentUser() {

        String emailAddress = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (emailAddress == null) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden access");
        }
        UserLoginResponse userLoginResponse = userService.getUserLoginResponse(emailAddress);

        return new ResponseEntity<>(userLoginResponse, HttpStatus.OK);
    }

}
