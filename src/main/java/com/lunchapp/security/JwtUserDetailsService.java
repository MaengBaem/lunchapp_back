package com.lunchapp.security;

import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lunchapp.model.member.Member;
import com.lunchapp.model.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JwtUserDetailsService implements UserDetailsService {

	private final MemberRepository userRepository;

	@Override
	public CustomSecurityUser loadUserByUsername(String userName) throws UsernameNotFoundException {
		Member member = userRepository.findByUserName(userName)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with userName: " + userName));
		return new CustomSecurityUser(member);
	}
	
	public CustomSecurityUser loadUserByUserId(String userId) throws UsernameNotFoundException {
		Member member = userRepository.findById(UUID.fromString(userId))
				.orElseThrow(() -> new UsernameNotFoundException("User not found with userId: " + userId));
		return new CustomSecurityUser(member);
	}
}
