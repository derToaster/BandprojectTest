package com.example.Bandproject.services;


import com.example.Bandproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/registration").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/usersecretpage").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .and()
                .logout().permitAll();



    }
    @Bean
    UserDetailsService userDetailsService (DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource){
        };

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}

