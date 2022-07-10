package net.obcy.bookrental.model.request;

import lombok.Data;

@Data
public class UserLoginRequest {

    private String emailAddress;

    private String password;

}
