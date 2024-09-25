package security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class UserDetailsServiceConfig {
    @Bean
    public UserDetailsService userDetailsService(){
        var userDetailsManager = new InMemoryUserDetailsManager();
        var user = User.withUsername("user").password("12345")
                .roles("USER").build();
        var admin = User.withUsername("admin").password("admin12345")
                .roles("ADMIN").build();
        userDetailsManager.createUser(user);
        userDetailsManager.createUser(admin);
        return userDetailsManager;
    }
}
