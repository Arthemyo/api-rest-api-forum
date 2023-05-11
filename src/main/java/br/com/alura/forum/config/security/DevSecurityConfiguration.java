package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@Profile("dev")
public class DevSecurityConfiguration {
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/**").permitAll()
        .and().csrf().disable();
		return http.build();
        
    }

	@Bean
	AutenticacaoService autenticacaoService() {
		return new AutenticacaoService();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	   public AuthenticationManager authenticationManager(
	           AuthenticationConfiguration authenticationConfiguration) throws Exception {
	       return authenticationConfiguration.getAuthenticationManager();
	   }
	
}
