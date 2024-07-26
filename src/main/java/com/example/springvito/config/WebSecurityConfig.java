package com.example.springvito.config;

import com.example.springvito.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    private final AuthProviderImpl authProvider;

    @Autowired
    public WebSecurityConfig(AuthProviderImpl authProvider) {
        this.authProvider = authProvider;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/springvito/registration/log-in",
                                "springvito/registration/sign-up", "/springvito/registration/sign-up/register",
                                "springvito","springvito/autos","springvito/personal-items","springvito/realty",
                                "/styles/cssandjs/styles.css")
                .permitAll().anyRequest().hasRole("ADMIN"))
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/springvito"))
                .formLogin(formLogin -> formLogin
                .loginPage("/springvito/registration/log-in").loginProcessingUrl("/process-log-in")
                .defaultSuccessUrl("/springvito")
                .failureUrl("/springvito/registration/log-in"));
        return http.build();
    }




}
