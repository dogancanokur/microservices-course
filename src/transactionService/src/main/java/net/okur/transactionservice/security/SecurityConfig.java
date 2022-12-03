package net.okur.transactionservice.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author dogancan.okur
 * 3.12.2022 21:34
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${service.security.secure-key-username}")
    private String SECURE_KEY_USERNAME;
    @Value("${service.security.secure-key-password}")
    private String SECURE_KEY_PASSWORD;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication() //
                .passwordEncoder(encoder) //
                .withUser(SECURE_KEY_USERNAME)//
                .password(encoder.encode(SECURE_KEY_PASSWORD))//
                .roles("USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable();
//        http.authorizeRequests().
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated();

        http.authorizeHttpRequests((authorizeHttpRequests) ->
                        authorizeHttpRequests
                                .antMatchers("/h2-console/**").permitAll()//
                                .anyRequest().hasRole("USER")//
                )
                .httpBasic(Customizer.withDefaults());
        http.headers().frameOptions().sameOrigin();
    }
}
