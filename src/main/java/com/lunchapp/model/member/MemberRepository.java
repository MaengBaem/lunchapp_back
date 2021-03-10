package com.lunchapp.model.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUserName(String userName);

	Optional<Member> findByEmail(String email);

}
