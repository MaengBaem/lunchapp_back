package com.lunchapp.security;

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
    public CustomSecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
    	Member member = userRepository.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
		return new CustomSecurityUser(member);
    }
}
