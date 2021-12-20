package com.usedcar.config;

import com.usedcar.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Kunlong Wang
 * @create 2021-11-21 23:05
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    CaptchaFilter captchaFilter;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Autowired
    UserDetailServiceImpl userDetailService;

    @Autowired
    JwtLogoutSuccessHandler jwtLogoutSuccessHandler;

    @Bean
    JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager());
                return jwtAuthenticationFilter;
    }
    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        // Determine the password encryption form
        return new BCryptPasswordEncoder();
    }
    private static final String[] URL_WHITELIST = {
            // whitelist
            "/login",
            "/logout",
            "/getCaptcha",
            "/favicon.ico",
            "/swagger-ui",
            "/swagger-ui/*",

    };

    // Security config
    protected void configure(HttpSecurity http) throws Exception {
        // Allow cross-domain and Turn off csrf
        http.cors().and().csrf().disable()

                // Login Configuration Login result processing: success / failure
                .formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)

                // Logout
                .and()
                .logout()
                .logoutSuccessHandler(jwtLogoutSuccessHandler)

                // session forbidden
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // Config interception Rules
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll()


                .antMatchers(
                        HttpMethod.GET,
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
//                .antMatchers("/profile/**").anonymous()
//                .antMatchers("/common/download**").anonymous()
//                .antMatchers("/common/download/resource**").anonymous()
//                .antMatchers("/swagger-ui.html").anonymous()
//                .antMatchers("/swagger-resources/**").anonymous()
//                .antMatchers("/webjars/**").anonymous()
//                .antMatchers("/*/api-docs").anonymous()
//                .antMatchers("/druid/**").anonymous()
                .antMatchers("/swagger-ui.html").anonymous()
                .antMatchers("/v2/**").anonymous()
                .antMatchers("/swagger-resources/**").anonymous()

                .anyRequest().authenticated()

                // exception handler
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // filter
                .and()
                .addFilter(jwtAuthenticationFilter())
                .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)

        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }
}
