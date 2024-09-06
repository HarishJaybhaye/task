package com.tech.task.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tech.task.bo.StudentBo;
import com.tech.task.entity.Student;
import com.tech.task.repository.StudentRepository;

@Service
public class UserInfoService implements UserDetailsService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Student> credential = studentRepository.findByUserName(username);

		return credential.map(CustomUserDeatils::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with name : " + username));
	}

}
