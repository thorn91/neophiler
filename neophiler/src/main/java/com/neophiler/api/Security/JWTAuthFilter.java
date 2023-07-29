package com.neophiler.api.Security;

import com.neophiler.utilities.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Service
public class JWTAuthFilter extends OncePerRequestFilter {
    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            var jwt = parseJWT(request);

            if (jwtService.isValidJWT(jwt)) {
                var info = jwtService.getJWTInfo(jwt);

                var authenticationToken = new UsernamePasswordAuthenticationToken(info, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                request.getSession().setAttribute("username", info.userName);
            }
        } catch (Exception e) {
            System.err.println("Error parsing JWT " + e.getMessage());
        }

        filterChain.doFilter(request, response);
    }

    private String parseJWT(HttpServletRequest request) {
        var authHeader = request.getHeader(JWTService.headerName);

        if (StringUtils.IsNotNullOrOnlyWhiteSpace(authHeader) && authHeader.startsWith(JWTService.tokenPrefix)) {
            return authHeader.replace(JWTService.tokenPrefix, "");
        }

        return null;
    }
}
