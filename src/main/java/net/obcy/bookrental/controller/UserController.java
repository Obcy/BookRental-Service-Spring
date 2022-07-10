package net.obcy.bookrental.controller;


import net.obcy.bookrental.model.User;
import net.obcy.bookrental.model.request.UserRegisterRequest;
import net.obcy.bookrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        User user = userService.registerUser(userRegisterRequest);
        return new ResponseEntity<>(user.getId().toString(), HttpStatus.OK);
    }

    @GetMapping()
    public Page<User> getUserList(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.findAll(pageable);
    }
}
