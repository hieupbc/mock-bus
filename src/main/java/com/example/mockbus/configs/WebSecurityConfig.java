package com.example.mockbus.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableJpaAuditing
@Import(RepositoryRestMvcAutoConfiguration.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${rememberme.key}")
    private String REMEMBER_ME_SECRET_KEY;
    @Value("${rememberme.valid-time}")
    private int REMEMBERME_VALID_TIME;
    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/rest/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/employee/**").hasAnyRole("ADMIN", "EMPLOYEE")
                .antMatchers("/**").permitAll()
                .and()
            .formLogin()
                .successHandler(authenticationSuccessHandler)
            .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
            .rememberMe()
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(REMEMBERME_VALID_TIME)
                .key(REMEMBER_ME_SECRET_KEY).and()
            .logout()
                .logoutUrl("/logout")
                .and()
            .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
            .csrf()
                .disable();
    }
}
