package com.ProyectoWeb.EduTech.Security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        var authorities = authentication.getAuthorities();

        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            response.sendRedirect("/administrador");
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ESTUDIANTE"))) {
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/inicio");
        }
    }
}
