package com.neophiler.api.controller.external.dto;

import com.neophiler.domain.core.user.User;

public class UserDTO {
    public String firstName;
    public String lastName;
    public String userName;
    public String email;
    public String password;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
