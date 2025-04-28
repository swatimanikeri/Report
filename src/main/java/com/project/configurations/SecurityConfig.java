package com.project.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	            		.requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**", "/about", "/eventsActivities","/reportG","/report.html","dashboard","/jasperpdf/export").permitAll()

	                .requestMatchers("/mou").hasRole("MOU")
	                .requestMatchers("/SponsoredProject").hasRole("SPON")
	                .requestMatchers("/TechnicalEvent").hasRole("TECH")
	                .requestMatchers("/IndustrialVisit").hasRole("IND")
	                .requestMatchers("/compesaCsi").hasRole("COMP")
	                .requestMatchers("/Community").hasRole("COMM")
	                .requestMatchers("/ExpLec").hasRole("EXP")
	                .requestMatchers("/AlumniContribution").hasRole("ALUMNI")
	                .requestMatchers("/jasperpdf/export").hasRole("JASPER")
	                .requestMatchers("/").hasRole("STUDENT")
	                .requestMatchers("/").hasRole("FACULTY")
	                
	                .requestMatchers("/").hasRole("VALUE")
	                
	                
	               // Restrict access to admin pages
	                .anyRequest().authenticated() // All other requests require authentication
	            )
	            .formLogin()
	            .and()
	            .logout(logout -> logout
//	                    .logoutUrl("/logout")
	                     .logoutSuccessUrl("/login?logout")
	                     .invalidateHttpSession(true) // Invalidate session on logout
	                     .deleteCookies("JSESSIONID") // Redirect to home page after logout
	                      .permitAll()
	                      )
	            .csrf(csrf -> csrf.disable());
	        return http.build();
	    }
	  @Bean
	    public StrictHttpFirewall strictHttpFirewall() {
	        StrictHttpFirewall firewall = new StrictHttpFirewall();
	        firewall.setAllowSemicolon(true);  // Allow semicolon in URLs
	        return firewall;
	    }
	    @Bean
	    public UserDetailsService  userDetailsService() {
	        UserDetails mou = User.withDefaultPasswordEncoder()
	                .username("mouNm")
	                .password("mou123")
	                .roles("MOU")
	                .build();

	        
	        UserDetails sponuser = User.withDefaultPasswordEncoder()
	                .username("spon")
	                .password("spon123")
	                .roles("SPON")
	                .build();
	        UserDetails techuser = User.withDefaultPasswordEncoder()
	                .username("tech")
	                .password("tech123")
	                .roles("TECH")
	                .build();
	        UserDetails induuser = User.withDefaultPasswordEncoder()
	                .username("indu")
	                .password("indu123")
	                .roles("IND")
	                .build();
	        UserDetails compuser = User.withDefaultPasswordEncoder()
	                .username("comp")
	                .password("comp123")
	                .roles("COMP")
	                .build();
	        UserDetails commuser= User.withDefaultPasswordEncoder()
	                .username("comm")
	                .password("comm123")
	                .roles("COMM")
	                .build();
	        
	        UserDetails expuser= User.withDefaultPasswordEncoder()
	                .username("exp")
	                .password("exp123")
	                .roles("EXP")
	                .build();
	        
	        UserDetails alumniuser= User.withDefaultPasswordEncoder()
	                .username("alumni")
	                .password("alumni123")
	                .roles("ALUMNI")
	                .build();
	        UserDetails jasparuser= User.withDefaultPasswordEncoder()
	                .username("jaspar")
	                .password("jaspar123")
	                .roles("FACULTY")
	                .build();
	        
	        UserDetails facuser= User.withDefaultPasswordEncoder()
	                .username("fac")
	                .password("fac123")
	                .roles("FACULTY")
	                .build();
	        
	     
	        
	        UserDetails stuuser= User.withDefaultPasswordEncoder()
	                .username("stu")
	                .password("stu123")
	                .roles("STUDENT")
	                .build();
	        
	        UserDetails valuser= User.withDefaultPasswordEncoder()
	                .username("val")
	                .password("val123")
	                .roles("VALUE")
	                .build();

	        return new InMemoryUserDetailsManager(mou,sponuser,techuser,induuser,compuser,commuser,expuser,alumniuser,jasparuser,facuser,stuuser,valuser);
	    }
}