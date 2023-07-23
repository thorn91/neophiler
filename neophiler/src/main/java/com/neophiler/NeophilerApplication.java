package com.neophiler;

import com.neophiler.domain.core.user.InternalUserRepository;
import com.neophiler.domain.core.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NeophilerApplication {
    @Autowired private InternalUserRepository internalUserRepository;

    public static void main(String[] args) {
        SpringApplication.run(NeophilerApplication.class, args);
    }
}
