package ru.midas.server.security;

import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MidasSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(@NonNull HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return httpSecurity.build();
    }

}
