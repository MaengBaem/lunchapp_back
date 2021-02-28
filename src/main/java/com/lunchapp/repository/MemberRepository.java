package com.lunchapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchapp.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUserName(String userName);

	Optional<Member> findByEmail(String email);

}
