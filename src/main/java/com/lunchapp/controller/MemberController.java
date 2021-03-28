package com.lunchapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.exception.ValidateException;
import com.lunchapp.model.dto.BaseDto;
import com.lunchapp.model.dto.member.MemberDto;
import com.lunchapp.service.member.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/create")
	public ResponseEntity<List<MemberDto>> createMember(@RequestBody MemberDto dto)
			throws DuplicateException, ValidateException {
		List<MemberDto> result = memberService.createMember(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/modify")
	public ResponseEntity<List<MemberDto>> modifyMember(@RequestBody MemberDto dto)
			throws DuplicateException, NoSearchObjectException, ValidateException {
		List<MemberDto> result = memberService.modifyMember(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/delete")
	public ResponseEntity<List<MemberDto>> deleteMember(@RequestBody MemberDto dto) throws NoSearchObjectException {
		List<MemberDto> result = memberService.deleteMember(dto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<MemberDto>> getMemberList() {
		List<MemberDto> result = memberService.getMemberList();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/prev")
	public ResponseEntity<List<BaseDto>> getRoleList() {
		List<BaseDto> result = memberService.getRoleList();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
