package com.neophiler.domain.core.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepository {
    InternalUserRepository internalUserRepository;

    public UserRepository(@Autowired InternalUserRepository internalUserRepository) {
        this.internalUserRepository = internalUserRepository;
    }

    public Optional<User> findUserByUserName(String userName) {
        return internalUserRepository.findByUserName(userName);
    }
}
