package com.neophiler.domain.core.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InternalUserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
