package net.obcy.bookrental.model.request;

import lombok.Data;

@Data
public class UserRegisterRequest {

    private String emailAddress;

    private String password;

    private String firstName;

    private String lastName;

}
