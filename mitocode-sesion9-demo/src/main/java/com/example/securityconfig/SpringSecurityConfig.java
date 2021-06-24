package com.example.securityconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//https://www.baeldung.com/spring-security-method-security
@EnableGlobalMethodSecurity(securedEnabled=true)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/home/**", "/css/**","/demo/**", "/scss/**","/js/**", "/img/**")
		  .permitAll()
		.anyRequest()
		  .authenticated()
		.and()
		    .formLogin()
		        .loginPage("/login")
		    .permitAll()
		.and()
		.logout()
			.invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login?logout")
	        .permitAll()
	     .and()
         .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
	}

	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}