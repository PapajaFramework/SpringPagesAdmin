package org.papaja.adminify.config;

import org.papaja.adminify.service.AuthUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SuppressWarnings({"all"})
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends GlobalMethodSecurityConfiguration {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AuthUserDetails();
    }

    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        public void configure(final WebSecurity web) {
            web.ignoring().antMatchers("/assets/**");
        }

        @Override
        protected void configure(final HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "SUPERUSER").and();

            http.authorizeRequests().antMatchers("/auth/**")
                    .permitAll().and();

            http.formLogin().loginPage("/auth/login")
                    .permitAll().and();

            http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login")
                    .permitAll().and();

            http.csrf().disable();
        }

    }

}
