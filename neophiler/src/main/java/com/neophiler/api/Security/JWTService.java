package com.neophiler.api.Security;

import com.neophiler.domain.core.user.User;
import com.neophiler.domain.core.user.UserRepository;
import com.neophiler.utilities.StringUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JWTService implements InitializingBean {
    public final static String cookieName = "SESSION";
    public final static String headerName = "Authorization";
    public final static String tokenPrefix = "Bearer ";
    private final static String userIdClaimName = "userId";
    @Autowired
    private UserRepository userRepository;
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    private Key encodedKey;
    @Value("${app.jwt.expirationInMs}")
    private long jwtExpiration;

    @Override
    public void afterPropertiesSet() throws Exception {
        encodedKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateJWT(User user) {
        return Jwts.builder().setSubject(user.getUsername()).claim(userIdClaimName, user.getId()).setExpiration(new Date(System.currentTimeMillis() + jwtExpiration)).signWith(encodedKey).compact();
    }

    public JWTInfo getJWTInfo(String token) {
        var claims = getAllClaims(token);
        var userId = getUserIdFromClaims(claims);
        var user = userRepository.mustFindByUserId(userId);
        return new JWTInfo(user.getId(), user.getUsername());
    }

    private Claims getAllClaims(String token) {
        return getJwtParser().parseClaimsJws(token).getBody();
    }

    private JwtParser getJwtParser() {
        return Jwts.parserBuilder().setSigningKey(encodedKey).build();
    }

    private String getUserNameFromClaims(Claims claims) {
        return claims.getSubject();
    }

    private Long getUserIdFromClaims(Claims claims) {
        return claims.get(userIdClaimName, Long.class);
    }

    public boolean isValidJWT(String authToken) {
        if (StringUtils.IsNullOrOnlyWhiteSpace(authToken)) {
            return false;
        }

        try {
            Jwts.parserBuilder().setSigningKey(encodedKey).build().parse(authToken);
            return true;
        } catch (MalformedJwtException e) {
            System.err.println("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.err.println("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.err.println("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("JWT claims string is empty: " + e.getMessage());
        }

        return false;
    }

    public static class JWTInfo {
        public final Long userId;
        public final String userName;

        public JWTInfo(Long userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }
    }
}
