package org.sample.security;
 

import java.util.ArrayList;
import java.util.List;

import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
 
@Component
public class CustomUserDetailsService implements AuthenticationProvider {

	@Autowired
    SampleService sampleService;
	
<<<<<<< HEAD:Skeleton/src/main/java/org/sample/security/CustomUserDetailsService.java
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("IM HERE");
		// TODO Auto-generated method stub
=======
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
>>>>>>> master:Skeleton/src/main/java/org/sample/security/CustomUserDetailsService.java
		return null;
	}

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
<<<<<<< HEAD:Skeleton/src/main/java/org/sample/security/CustomUserDetailsService.java
		// TODO Auto-generated method stub
		print(authentication);
		
		String name = authentication.getName();
=======
		/**
		 * Gets credentials from the authentication token. 
		 * This method gets called somewhere in the authentication process.
		 * The user is then loaded from the email.
		 */
		String email = authentication.getName();
>>>>>>> master:Skeleton/src/main/java/org/sample/security/CustomUserDetailsService.java
		String password = (String) authentication.getCredentials();
		User user = sampleService.loadUserByUserName(email);
		
		/**
		 * Creates a role for the authentication token. 
		 */
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        if(user == null){
        	throw new BadCredentialsException("username not found");
        }
        if(!user.getPassword().equals(password)){
        	throw new BadCredentialsException("Wrong Credentials");
        }
        
        Authentication auth = new UsernamePasswordIDAuthenticationToken(user.getId(), email, password, grantedAuths);

		return auth;
	}


	public boolean supports(Class<?> authentication) {
		return true;
	}
 

//   
 
}