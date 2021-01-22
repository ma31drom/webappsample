package by.grodno.pvt.site.webappsample.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;

public class UserWIthId extends org.springframework.security.core.userdetails.User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	private Integer id;
	
	public UserWIthId(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
	}

}
