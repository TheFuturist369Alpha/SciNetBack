package com.jalvis.SciNet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecConfig {

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

    //@Bean
    public SecurityFilterChain httpSec(HttpSecurity http) throws Exception{
        http.requiresChannel(channel->channel.anyRequest().requiresSecure())
        .authorizeHttpRequests(configure->

                configure.requestMatchers(HttpMethod.GET, "/bookapi/getbooks").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/index.html").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/bookapi/getbooksbysubjectid").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/bookapi/getbook").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/bookapi/createbook").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/bookapi/updatebooks").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/bookapi/updatebook").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/bookapi/deletebook").hasRole("ADMIN")



                );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }

}
