package com.lunchapp.service.member;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lunchapp.constants.Constants;
import com.lunchapp.constants.DBNAME;
import com.lunchapp.exception.DuplicateException;
import com.lunchapp.exception.NoSearchObjectException;
import com.lunchapp.exception.ValidateException;
import com.lunchapp.model.dto.BaseDto;
import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.member.MemberDto;
import com.lunchapp.model.member.Member;
import com.lunchapp.model.member.MemberRepository;
import com.lunchapp.model.member.ROLE;

import lombok.RequiredArgsConstructor;

@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
@Service
public class MemberService {
	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public Result<List<MemberDto>> createMember(MemberDto dto) {
		try {
			checkDuplicateEmailAndName(dto.getEmail(), dto.getUserName());
			validator(dto);
			String encryptPassword = passwordEncoder.encode(dto.getPassword());
			Member member = Member.builder().email(dto.getEmail()).userName(dto.getUserName()).password(encryptPassword)
					.role(ROLE.valueOf(dto.getRoleId())).build();
			memberRepository.save(member);
			return getMemberList();
		} catch (Exception e) {
			return new Result<List<MemberDto>>(null, e.getMessage());
		}
	}

	private void validator(MemberDto dto) throws ValidateException {
		checkEmail(dto.getEmail());
		checkPassword(dto.getPassword());
	}

	private void checkPassword(String password) throws ValidateException {
		if (password.length() < 4) {
			throw new ValidateException("비밀번호는 4자 이상 입력해야 합니다");
		}
	}

	private void checkEmail(String email) throws ValidateException {
		String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(email);
		if (!m.matches()) {
			throw new ValidateException("이메일이 형식이 휴효하지 않습니다");
		}
	}

	private void checkDuplicateEmailAndName(String email, String userName) throws DuplicateException {
		Member duplicate = memberRepository.findByEmailOrUserName(email, userName);
		if (duplicate != null)
			throw new DuplicateException(email, userName);
	}

	public Result<List<MemberDto>> modifyMember(MemberDto dto) {
		try {
			checkDuplicateEmailAndName(dto);
			Member member = memberRepository.findById(UUID.fromString(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.MEMBER.getKrname()));
			checkEmail(dto.getEmail());
			if (dto.getPassword() != null && dto.getPassword().equals(Constants.EMPTY_VALUE)) {
				checkPassword(dto.getPassword());
				String encryptPassword = passwordEncoder.encode(dto.getPassword());
				member.changePassword(encryptPassword);
			}
			member.modify(dto);
			return getMemberList();
		} catch (Exception e) {
			return new Result<List<MemberDto>>(null, e.getMessage());
		}
	}

	private void checkDuplicateEmailAndName(MemberDto dto) throws DuplicateException {
		Member duplicate = memberRepository.findByEmailOrUserName(dto.getEmail(), dto.getUserName());
		if (duplicate != null) {
			if (!duplicate.getId().toString().equals(dto.getId()))
				throw new DuplicateException(dto.getEmail(), dto.getUserName());
		}
	}

	public Result<List<MemberDto>> deleteMember(MemberDto dto) {
		// 나중에 제약 조건 걸어야 함
		try {
			Member member = memberRepository.findById(UUID.fromString(dto.getId()))
					.orElseThrow(() -> new NoSearchObjectException(DBNAME.MEMBER.getKrname()));
			memberRepository.delete(member);
			return getMemberList();
		} catch (Exception e) {
			return new Result<List<MemberDto>>(null, e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public Result<List<MemberDto>> getMemberList() {
		List<MemberDto> result = memberRepository.findAll().stream().map(MemberDto::new).collect(Collectors.toList());
		return new Result<List<MemberDto>>(result, Constants.RESULT_SUCCESS);
	}

	public Result<List<BaseDto>> getRoleList() {
		try {
			List<BaseDto> roleList = new ArrayList<BaseDto>();
			for (ROLE role : ROLE.values()) {
				BaseDto bDto = new BaseDto(role.name(), role.getValue());
				roleList.add(bDto);
			}
			return new Result<List<BaseDto>>(roleList, Constants.RESULT_SUCCESS);
		} catch (Exception e) {
			return new Result<List<BaseDto>>(null, e.getMessage());
		}
	}
}
