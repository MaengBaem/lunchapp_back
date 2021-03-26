package com.lunchapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.BaseDto;
import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.member.MemberDto;
import com.lunchapp.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/create")
	public Result<List<MemberDto>> createMember(@RequestBody MemberDto dto) {
		return memberService.createMember(dto);
	}

	@PostMapping("/modify")
	public Result<List<MemberDto>> modifyMember(@RequestBody MemberDto dto) {
		return memberService.modifyMember(dto);
	}

	@PostMapping("/delete")
	public Result<List<MemberDto>> deleteMember(@RequestBody MemberDto dto) {
		return memberService.deleteMember(dto);
	}

	@GetMapping("/all")
	public Result<List<MemberDto>> getMemberList() {
		return memberService.getMemberList();
	}
	
	@GetMapping("/prev")
	public Result<List<BaseDto>> getRoleList() {
		return memberService.getRoleList();
	}
}
