package com.tech.task.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.tech.task.entity.Student;

import java.util.Collection;

public class CustomUserDeatils implements UserDetails {

	private static final long serialVersionUID = -6631560564487170164L;
	private String username;
	private String password;

	public CustomUserDeatils(Student student) {

		this.username = student.getUserName();
		this.password = student.getPassword();
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}
