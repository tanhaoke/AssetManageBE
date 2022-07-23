package com.nashtech.rookies.java05.AssetManagement.security;

import com.nashtech.rookies.java05.AssetManagement.Model.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class UserPrincipal implements UserDetails {
	private String id;
	private String userName;
	private String passWord;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	public static UserPrincipal create(User user) {
		String userRole = user.getRole().toString();
		List<GrantedAuthority> grantedAuthorityList = Collections.singletonList(new SimpleGrantedAuthority(userRole));
		return new UserPrincipal(user.getId(), user.getUserName(), user.getPassWord(), grantedAuthorityList);
	}
	
	@Override
	public String getPassword() {
		return passWord;
	}
	
	@Override
	public String getUsername() {
		return userName;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
}
