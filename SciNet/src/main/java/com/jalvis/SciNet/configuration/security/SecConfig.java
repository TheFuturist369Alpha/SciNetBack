package com.jalvis.SciNet.configuration.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecConfig  {

   // @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails johnny= User.builder()
                .username("Johnny")
                .password("{noop}SEE9lu$9lu$")
                .roles("EMPLOYEE")
                .build();

        UserDetails gema= User.builder()
                .username("Gema")
                .password("{noop}Gem234")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails morgan= User.builder()
                .username("Morgan")
                .password("{noop}3.142")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
    return new InMemoryUserDetailsManager(johnny, gema, morgan);

    }

    @Bean
    public SecurityFilterChain httpSec(HttpSecurity http) throws Exception{
        return http.csrf(csrf->csrf.disable()).authorizeHttpRequests(
                auth->auth.requestMatchers("/signup/**").permitAll()
                        .anyRequest().permitAll()

        ).formLogin(Customizer.withDefaults()).build();


    }

    public AuthenticationManager authMan(UserDetailsService service, PasswordEncoder encoder){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(encoder);
        return new ProviderManager(List.of(provider));

    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
