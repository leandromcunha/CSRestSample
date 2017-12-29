package br.com.cs.rs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static String REALM = "MY_TEST_REALM";

    @Autowired
    public void configureGlobalSecurity(final AuthenticationManagerBuilder auth)
        throws Exception {

        // auth.jdbcAuthentication().dataSource(this.dataSource)
        // .usersByUsernameQuery(
        // "select username, password, enabled from users where username=?")
        // .authoritiesByUsernameQuery(
        // "select username, role from user_roles where username=?");

        auth.inMemoryAuthentication().withUser("admin").password("admin")
                        .roles("USER");
        auth.inMemoryAuthentication().withUser("user").password("user")
                        .roles("USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .anyRequest().authenticated()
                        .antMatchers("/**").hasRole("ADMIN")
                        .and().httpBasic().realmName(REALM)
                        .authenticationEntryPoint(this.getBasicAuthEntryPoint())
                        .and().csrf().disable();
    }

    @Bean
    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint() {
        return new CustomBasicAuthenticationEntryPoint();
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
