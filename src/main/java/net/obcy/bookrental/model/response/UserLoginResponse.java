package net.obcy.bookrental.model.response;

import lombok.Data;

import java.util.List;

@Data
public class UserLoginResponse {
    String emailAddress;
    List<String> roles;
    String firstName;
    String lastName;

}
