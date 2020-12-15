package by.grodno.pvt.site.webappsample.service.impl;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.grodno.pvt.site.webappsample.domain.OldUser;
import by.grodno.pvt.site.webappsample.service.UserService;

@Service
public class UserAuthService implements UserDetailsService {

	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return service.findByUserName(username).map(
				userFromBd -> new User(userFromBd.getUsername(), userFromBd.getPassword(), toAuthorities(userFromBd)))
				.orElse(null);
	}

	private Collection<? extends GrantedAuthority> toAuthorities(OldUser findByUserName) {
		return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + findByUserName.getRole()));
	}

}
