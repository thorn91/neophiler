package com.neophiler.domain.security;

import com.neophiler.domain.core.user.User;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
//@Scope(value = "thread", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SecurityContext {
    private User user;

    protected SecurityContext() {}

    public void setAuthorizationContext(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
