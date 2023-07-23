package com.neophiler.domain.core.user;

import com.neophiler.domain.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepository {
    InternalUserRepository internalUserRepository;

    @Autowired
    public UserRepository(InternalUserRepository internalUserRepository) {
        this.internalUserRepository = internalUserRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return internalUserRepository.findByUserName(userName);
    }

    public Optional<User> findByEmail(String email) {
        return internalUserRepository.findByEmailIgnoreCase(email);
    }

    public User mustFindByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new NotFoundException(String.format("User not found with email %s", email), UserExceptionIdentifier.USER_NOT_FOUND));
    }
}
