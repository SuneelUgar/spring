package com.ugar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
                .antMatchers("./myNotices", "/myContacts").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }

    /*    @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails admin = User.withDefaultPasswordEncoder().username("admin")
                    .password("12345").authorities("admin").build();
            UserDetails user = User.withDefaultPasswordEncoder().username("user")
                    .password("12345").authorities("read").build();
            return new InMemoryUserDetailsManager(admin, user);
        }*/

    /*
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
            UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
            UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
            userDetailsService.createUser(admin);
            userDetailsService.createUser(user);
            return userDetailsService;
        }
    */
 /*   @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
