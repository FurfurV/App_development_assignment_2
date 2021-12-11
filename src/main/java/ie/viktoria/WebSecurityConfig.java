package ie.viktoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: Viktoria Cseke
 * @studentNumber: R00180598
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/newnote/**", "/newstudent/**").hasRole("MENTOR")
                .antMatchers("/students", "/student/**","/searchstudent/**").hasAnyRole("REVIEWER", "MENTOR")
                .antMatchers("/api/**", "/myapi/**").hasRole("API")
                .antMatchers("/css/**", "/img/**",
                        "/webjars/bootstrap/**", "/",
                        "/logout", "/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout().logoutSuccessUrl("/")
                .and().httpBasic()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService(){
//        String encodedPass = passwordEncoder().encode("password");
//        UserDetails user1 = User.withUsername("reviewer")
//                .password(encodedPass)
//                .roles("REVIEWER")
//                .build();
//        UserDetails user2 = User.withUsername("mentor")
//                .password(encodedPass)
//                .roles("MENTOR")
//                .build();
//        UserDetails user3 = User.withUsername("api")
//                .password(encodedPass)
//                .roles("API")
//                .build();
//        return new InMemoryUserDetailsManager(user1,user2,user3);
//    }
}
