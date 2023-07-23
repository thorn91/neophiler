package com.neophiler.api.controller.external;


import com.neophiler.api.controller.external.dto.UserDTO;
import com.neophiler.domain.core.user.UserRepository;
import com.neophiler.domain.core.user.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.USER_API)
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public UserDTO getUserByEmail(@PathVariable String email) {
        return new UserDTO(userRepository.mustFindByEmail(email));
    }


    @GetMapping("/testerrrrr")
    @Transactional
    public UserDTO hello() {
        var newUser = userService.createNewUser("test", "test", "test", "test", "test");
        return new UserDTO(newUser);
    }
}
