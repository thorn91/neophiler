package com.neophiler.api.Security;

import com.neophiler.domain.core.user.UserRepository;
import com.neophiler.domain.core.user.UserService;
import com.neophiler.domain.security.SecurityContext;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private SecurityContext securityContext;

    protected String login(String userIdentifier, String password, HttpServletResponse response) {
        var user = userRepository.mustFindByUserNameOrEmail(userIdentifier, userIdentifier);
        user.validatePassword(password);
        securityContext.setAuthorizationContext(user);

        return jwtService.generateJWT(user);
    }

    protected String signUp(String firstName, String lastName, String userName, String email, String password, HttpServletResponse response) {
        var user = userService.createNewUser(firstName, lastName, userName, email, password);
        securityContext.setAuthorizationContext(user);

        return jwtService.generateJWT(user);
    }
}
