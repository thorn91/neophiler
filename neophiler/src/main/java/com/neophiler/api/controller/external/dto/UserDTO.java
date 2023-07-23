package com.neophiler.api.controller.external.dto;

import com.neophiler.domain.core.user.User;

public class UserDTO {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
