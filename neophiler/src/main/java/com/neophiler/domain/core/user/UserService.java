package com.neophiler.domain.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(String firstName, String lastName, String userName, String email, String password) {
        var user = User.getBuilder()
                .firstName(firstName)
                .lastName(lastName)
                .userName(userName)
                .email(email)
                .password(password)
                .build();

        return userRepository.save(user);
    }
}
