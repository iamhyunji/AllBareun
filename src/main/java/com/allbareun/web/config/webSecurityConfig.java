package com.allbareun.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;




@Configuration
public class webSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/*").permitAll()
				.antMatchers("/admin/").hasAnyRole("ADMIN")
				.antMatchers("/mygoal/**","/mypage/**","/goal/reg","/goal/participate").authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.successHandler(successHandler)
				.defaultSuccessUrl("/index")
				.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/index")
			.invalidateHttpSession(true)
			.and()
			.csrf()
				.disable();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
	        .usersByUsernameQuery("select email id, password, 1 enabled from User where email=?")
	        .authoritiesByUsernameQuery("select email id, 'ROLE_USER' roleId from User where email=?")
			.passwordEncoder(new BCryptPasswordEncoder());
		auth
			.inMemoryAuthentication()
			.withUser("admin@allbareun.com")
			.password("{noop}9599")
			.roles("ADMIN");

				
	}
}
