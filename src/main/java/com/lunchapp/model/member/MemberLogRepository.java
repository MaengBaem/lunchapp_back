package com.lunchapp.model.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberLogRepository extends JpaRepository<MemberLog, Long> {

	MemberLog findByMemberAndLogoutTimeIsNull(Member member);

}
