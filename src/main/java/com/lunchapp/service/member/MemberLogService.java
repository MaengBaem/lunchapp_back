package com.lunchapp.service.member;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.constants.DBNAME;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.model.member.Member;
import com.lunchapp.model.member.MemberLog;
import com.lunchapp.model.member.MemberLogRepository;
import com.lunchapp.model.member.MemberRepository;
import com.lunchapp.security.CustomSecurityUser;

import lombok.RequiredArgsConstructor;

@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@RestController
public class MemberLogService {
	private final MemberLogRepository memberLogRepository;
	private final MemberRepository userRepository;

	public void loginLog(CustomSecurityUser userDetails, String token) throws NoSearchObjectException {
		Member member = userRepository.findById(UUID.fromString(userDetails.getId()))
				.orElseThrow(() -> new NoSearchObjectException(DBNAME.MEMBER.toString()));
		MemberLog log = new MemberLog(member, LocalDateTime.now(),token);
		memberLogRepository.save(log);
	}

	public void logoutLog(String userId, String token) throws NoSearchObjectException {
		Member member = userRepository.findById(UUID.fromString(userId))
				.orElseThrow(() -> new NoSearchObjectException(DBNAME.MEMBER.toString()));
		MemberLog log = memberLogRepository.findByMemberAndTokenAndLogoutTimeIsNull(member, token);
		log.logout(LocalDateTime.now());
	}
}
