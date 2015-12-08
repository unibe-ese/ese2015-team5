package org.sample.security;

import java.util.Collection;

import org.sample.model.User;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthenticationToken extends AbstractAuthenticationToken{
	
	private User user;
	
	
	public UserAuthenticationToken(
			Collection<? extends GrantedAuthority> authorities,
			User user) {
		super(authorities);
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getCredentials() {
		return user;
	}

	@Override
	public Object getPrincipal() {
		return user;
	}

}
