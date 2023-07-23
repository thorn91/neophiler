package com.neophiler.api.controller.external;


import com.neophiler.api.controller.external.dto.UserDTO;
import com.neophiler.domain.core.user.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.USER_API)
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        return new UserDTO(userRepository.mustFindByEmail(email));
    }


    @GetMapping("/")
    @Transactional
    public String hello() {
        var user = User.getBuilder()
                .firstName("John")
                .lastName("Doe")
                .userName("jdoe")
                .email("test@test.com")
                .password("password")
                .build();

        internalUserRepository.save(user);

        return "Hello World!";
    }
}
