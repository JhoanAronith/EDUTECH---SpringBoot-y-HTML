package com.ProyectoWeb.EduTech.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final CustomAuthenticationSuccessHandler successHandler;
    
    public SecurityConfig(CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth -> auth
                .requestMatchers("/").permitAll()
                .requestMatchers("/registro", "/inicio",
                        "/nosotros", "/login", "/cursos/**",
                        "/images/**", "/css/**").permitAll()
                .requestMatchers("/administrador/**").hasRole("ADMIN")
                .requestMatchers("/profile").hasRole("ESTUDIANTE")
                .anyRequest().authenticated()
        )
        .formLogin(form -> form
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(successHandler)
        )
        .logout(config -> config.logoutSuccessUrl("/inicio"))
        .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
