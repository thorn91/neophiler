package com.neophiler.domain.core.user;

import com.neophiler.domain.core.exception.ValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void passwordCannotBeBlank() {
        assertThrows(ValidationException.class, () -> {
            User.getBuilder()
                    .firstName("test")
                    .lastName("test")
                    .userName("test")
                    .email("test@test.com")
                    .password(null)
                    .build();
        });
    }
}
