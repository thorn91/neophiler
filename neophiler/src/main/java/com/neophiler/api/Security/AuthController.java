package com.neophiler.api.Security;

import com.neophiler.api.controller.external.ControllerConstants;
import com.neophiler.api.controller.external.dto.LoginDTO;
import com.neophiler.api.controller.external.dto.SignUpDTO;
import com.neophiler.api.controller.external.dto.TokenDTO;
import com.neophiler.domain.core.user.UserRepository;
import com.neophiler.domain.core.user.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ControllerConstants.AUTH_API)
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Transactional
    public TokenDTO login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {
        return new TokenDTO(authService.login(loginDTO.userIdentifier, loginDTO.password, response));
    }

    @PostMapping("/signup")
    @Transactional
    public TokenDTO signUp(@RequestBody SignUpDTO signUpDTO, HttpServletResponse response) {
        return new TokenDTO(authService.signUp(signUpDTO.firstName, signUpDTO.lastName, signUpDTO.userName, signUpDTO.email, signUpDTO.password, response));
    }
}
