package com.admiral.tsp.timesheetportal.csrf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * Set up a password encoder
     */

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        AuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();

        AuthenticationSuccessHandler successHandler = new CustomAuthenticationSuccessHandler();

        http
                .authorizeRequests()
                .antMatchers("/reports/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/Invoices").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/ManageRoles").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/register").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/registerAgency").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/ManageRoles/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/contractorList/*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/contractor_view").access("hasRole('ROLE_CONTRACTOR')")
                .antMatchers("/Approvals").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/h2_console/**").permitAll()
                .antMatchers("/").permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler(successHandler)
                .loginPage("/login")
                //.defaultSuccessUrl("/contractor_view.html")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf()
                .ignoringAntMatchers("/h2-console/**")
        ;

        http.headers().frameOptions().disable();

    }

    /**
     * Point the authentication to our own user service
     */

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }


}
