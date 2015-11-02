package org.sample.security;
 

import java.util.ArrayList;
import java.util.List;

import org.sample.controller.service.SampleService;
import org.sample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("IM HERE");
		// TODO Auto-generated method stub
		return null;
	}

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		print(authentication);
		
		String name = authentication.getName();
		String password = (String) authentication.getCredentials();
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
        User user = sampleService.loadUserByUserName(name);
        if(user == null){
        	throw new BadCredentialsException("username not found");
        }
        if(!user.getPassword().equals(password)){
        	throw new BadCredentialsException("Wrong Credentials");
        }
        System.out.println(auth.toString());

		return auth;
	}

	private void print(Authentication authentication) {
		System.out.println(authentication.getName());
		System.out.println(authentication.getCredentials());
		System.out.println(authentication.getAuthorities());		
	}

	public boolean supports(Class<?> authentication) {
		return true;
	}
 

//   
 
}