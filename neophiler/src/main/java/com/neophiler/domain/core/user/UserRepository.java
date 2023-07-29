package com.neophiler.domain.core.user;

import com.neophiler.domain.core.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepository implements UserDetailsService {
    InternalUserRepository internalUserRepository;

    @Autowired
    public UserRepository(InternalUserRepository internalUserRepository) {
        this.internalUserRepository = internalUserRepository;
    }

    public Optional<User> findByUserName(String userName) {
        return internalUserRepository.findByUserName(userName);
    }

    public Optional<User> findByUserNameOrEmail(String userName, String email) {
        return internalUserRepository.findByUserNameIgnoreCaseOrEmailIgnoreCase(userName, email);
    }

    public User mustFindByUserNameOrEmail(String userName, String email) {
        return findByUserNameOrEmail(userName, email).orElseThrow(() -> new NotFoundException(String.format("User not found with username %s or email %s", userName, email), UserExceptionIdentifier.USER_NOT_FOUND));
    }

    public Optional<User> findByEmail(String email) {
        return internalUserRepository.findByEmailIgnoreCase(email);
    }

    public Optional<User> findByUserId(Long userId) {
        return internalUserRepository.findById(userId);
    }

    public User mustFindByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new NotFoundException(String.format("User not found with email %s", email), UserExceptionIdentifier.USER_NOT_FOUND));
    }

    public User mustFindByUserId(Long userId) {
        return findByUserId(userId).orElseThrow(() -> new NotFoundException(String.format("User not found with id %s", userId), UserExceptionIdentifier.USER_NOT_FOUND));
    }

    protected User save(User user) {
        return internalUserRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return findByUserName(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User not found with username %s", username)));
    }
}
