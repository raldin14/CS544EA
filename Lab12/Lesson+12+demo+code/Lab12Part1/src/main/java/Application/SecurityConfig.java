package Application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> {
                            auth.requestMatchers("/shop").permitAll();
                            auth.requestMatchers("/orders").hasRole("EMPLOYEE");
                            auth.requestMatchers("/payments").hasRole("FINANCE");
                        }
                    ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailService(){
        UserDetails bob = User.withDefaultPasswordEncoder()
                .username("bob")
                .password("pass")
                .roles("EMPLOYEE", "SALES")
                .build();

        UserDetails mary = User.withDefaultPasswordEncoder()
                .username("mary")
                .password("pass")
                .roles("EMPLOYEE","FINANCE")
                .build();

        return new InMemoryUserDetailsManager(bob,mary);
    }
}
