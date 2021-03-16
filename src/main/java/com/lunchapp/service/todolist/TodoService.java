package com.lunchapp.service.todolist;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lunchapp.constants.Constants;
import com.lunchapp.model.dto.ResponseDto;
import com.lunchapp.model.dto.Result;
import com.lunchapp.model.todolist.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoService {

	private final ProjectRepository projectRepository;

	public Result<List<ResponseDto>> getProjects() {
		List<ResponseDto> result =  projectRepository.findAll().stream().map(p -> new ResponseDto(p)).collect(Collectors.toList());
		return new Result<List<ResponseDto>>(result, Constants.RESULT_SUCCESS);
	}
}
