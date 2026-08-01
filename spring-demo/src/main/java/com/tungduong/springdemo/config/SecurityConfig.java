package com.tungduong.springdemo.config;

import com.tungduong.springdemo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(UserService service){
        return new CustomUserDetailService(service);
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService){
       DaoAuthenticationProvider dao = new DaoAuthenticationProvider(userDetailsService);
       dao.setPasswordEncoder(passwordEncoder());
       return dao;

    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/","/login","/register").permitAll()
                        .requestMatchers("/user/**").hasRole("ADMIN")
                .anyRequest().authenticated());
        http.formLogin(form->form.loginPage("/login").failureUrl("/login?error"));
        http.exceptionHandling(e-> e.accessDeniedPage("/access-denied"));
        http.sessionManagement(s->s.maximumSessions(1).maxSessionsPreventsLogin(true).expiredUrl("/login?expire"));
        return http.build();
    }
}
