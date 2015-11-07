package org.sample.security;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class UsernamePasswordIDAuthenticationToken extends
		UsernamePasswordAuthenticationToken {

	private long id;

	private static final long serialVersionUID = -8362878136811453106L;

	public UsernamePasswordIDAuthenticationToken(long id, Object principal,
			Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		this.id = id;
	}

	public long getId() {
		return id;
	}
	

}
