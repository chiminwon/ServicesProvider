package com.ming.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Bean
  @Override
  protected UserDetailsService userDetailsService() {
    return super.userDetailsService();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin")
        .password("$2a$10$DIZ0IvEDqat7uE20Ewpm0usdo5DLkWOo/ExbCxAHxG8pbxXudqpcK")
        .roles("admin")
        .and()
        .withUser("user")
        .password("$2a$10$DIZ0IvEDqat7uE20Ewpm0usdo5DLkWOo/ExbCxAHxG8pbxXudqpcK")
        .roles("user");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.antMatcher("/oauth/**")
        .authorizeRequests()
        .antMatchers("/oauth/**")
        .permitAll()
        .and()
        .csrf()
        .disable();
  }
}
