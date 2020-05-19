package com.admiral.tsp.timesheetportal.security.config;

import com.admiral.tsp.timesheetportal.security.services.CustomAuthenticationSuccessHandler;
import com.admiral.tsp.timesheetportal.security.services.MyUserDetailsService;
import org.apache.catalina.Context;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.time.Duration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(MyUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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
                .antMatchers("/newUser").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/createUser").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/registerAgency").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/newAgency").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/createAgency").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/ManageRoles/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/contractorList/*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/api/admin/**").access("hasRole('ROLE_ADMIN')")

                .antMatchers("/contractorView").access("hasRole('ROLE_CONTRACTOR')")
                .antMatchers("/createTimeSheet").access("hasRole('ROLE_CONTRACTOR')")
                .antMatchers("/newTimeSheet").access("hasRole('ROLE_CONTRACTOR')")

                .antMatchers("/Approvals").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/Contractors").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/api/timeSheets/**").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/newApproveReview/*").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/createReview").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/newRejectedReview/*").access("hasRole('ROLE_MANAGER')")
                .antMatchers("/createRejectedReview").access("hasRole('ROLE_MANAGER')")

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

    @Bean
    public RequestDataValueProcessor aRequestDataValueProcessor() {
        return new CsrfRequestDataValueProcessor();
    }


}
