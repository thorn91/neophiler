package com.neophiler.domain.core.user;

import com.neophiler.domain.BaseEntity;
import com.neophiler.domain.core.exception.NotAuthorizedException;
import com.neophiler.domain.core.exception.ValidationException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Entity
@Table(name = "user", schema = "public")
public class User extends BaseEntity implements UserDetails {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    protected User() {
    }

    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.userName = builder.userName;
        this.email = builder.email;

        setPassword(builder.password);
    }

    public static RequiredFirstName getBuilder() {
        return new UserBuilder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    private void setPassword(String password) {
        if (password == null) {
            throw new ValidationException("Missing password", UserExceptionIdentifier.PASSWORD_CANNOT_BE_EMPTY);
        }

        this.password = User.passwordEncoder.encode(password);
    }

    public void validatePassword(String password) {
        if (!User.passwordEncoder.matches(password, this.password)) {
            throw new NotAuthorizedException("Invalid password", UserExceptionIdentifier.INVALID_PASSWORD);
        }
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public interface RequiredFirstName {
        RequiredLastName firstName(String firstName);
    }

    public interface RequiredLastName {
        RequiredUserName lastName(String lastName);
    }

    public interface RequiredUserName {
        RequiredEmail userName(String userName);
    }

    public interface RequiredEmail {
        RequiredPassword email(String email);
    }

    public interface RequiredPassword {
        OptionalParameters password(String password);
    }

    public interface OptionalParameters {
        User build();
    }

    protected static class UserBuilder implements RequiredFirstName, RequiredLastName, RequiredUserName, RequiredEmail, RequiredPassword, OptionalParameters {
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private String password;

        @Override
        public RequiredLastName firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public RequiredUserName lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public RequiredEmail userName(String userName) {
            this.userName = userName;
            return this;
        }

        @Override
        public RequiredPassword email(String email) {
            this.email = email;
            return this;
        }

        @Override
        public OptionalParameters password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public User build() {
            return new User(this);
        }
    }
}
