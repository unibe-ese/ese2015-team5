package org.sample.controller.service;
 

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.sample.model.User;
import org.sample.model.dao.UserDao;
import org.sample.security.UsernamePasswordIDAuthenticationToken;
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
 
/**
 * Provides Authentication for Users, using the DB.
 * 
 * @author ESE Team5
 *
 */

@Component
public class CustomUserDetailsService implements AuthenticationProvider {

	@Autowired
    UserDao userDao;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return null;
	}

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		
		/**
		 * Gets credentials from the authentication token. 
		 * This method gets called somewhere in the authentication process.
		 * The user is then loaded from the email.
		 */
		String email = authentication.getName();
		String password = (String) authentication.getCredentials();
		password = DigestUtils.md5Hex(password); 
				
		User user = null;
		for (User u:userDao.findAll())
		{
			if(u.getEmail().equals(email))
				user = u;
		}
		
		/**
		 * Creates a role for the authentication token. 
		 */
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        if(user == null){
        	throw new BadCredentialsException("username not found");
        }
        if(!user.getPassword().equals(password)){
        	System.out.println(user.getPassword());
        	System.out.println(password);
        	throw new BadCredentialsException("Wrong Credentials");
        }
        
        Authentication auth = new UsernamePasswordIDAuthenticationToken(user.getId(), email, password, grantedAuths);

		return auth;
	}


	public boolean supports(Class<?> authentication) {
		return true;
	}
}