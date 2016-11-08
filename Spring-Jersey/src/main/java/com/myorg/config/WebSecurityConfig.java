package com.myorg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
            .authorizeRequests()
            	.antMatchers("/", "/home").permitAll()
            	.antMatchers("/admin/**").hasAuthority("ADMIN")
            	//.antMatchers("/rest/test/city/**").hasAuthority("ADMIN")
            	.antMatchers("/db/**").access("hasAuthority('ADMIN') and hasAuthority('DBA')")
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	//.loginPage("main.html")
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
            .logout()
            	.logoutSuccessUrl("/login?loggedOut")
                .permitAll();
		//http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(true);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").authorities("USER").and()
                .withUser("admin").password("password").authorities("USER", "ADMIN");
        //auth.userDetailsService(null).passwordEncoder(passwordEncoder);
    }
}
