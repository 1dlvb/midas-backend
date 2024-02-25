package ru.midas.server.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.midas.server.auth.JwtFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain filterChain(@NonNull HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(auth -> auth
                    .requestMatchers("api/v1/midas/admin/**").hasAuthority("ADMIN")
                    .requestMatchers("api/v1/midas/**").permitAll()
                );
        httpSecurity.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();

    }

}
