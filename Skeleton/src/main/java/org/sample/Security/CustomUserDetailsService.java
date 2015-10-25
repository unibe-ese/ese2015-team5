package org.sample.Security;
 

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
 
@Component
public class CustomUserDetailsService implements AuthenticationProvider {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("IM HERE");
		// TODO Auto-generated method stub
		return null;
	}

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("IM HERE");
		System.out.println(authentication.getName());
		return null;
	}

	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}
 

//   
 
}