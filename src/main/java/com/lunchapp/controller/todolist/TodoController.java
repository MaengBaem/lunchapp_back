package com.lunchapp.controller.todolist;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunchapp.model.dto.ResponseDto;
import com.lunchapp.model.dto.Result;
import com.lunchapp.model.dto.todolist.TodoListResponseDto;
import com.lunchapp.service.todolist.TodoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/todo")
@RestController
public class TodoController {
	private final TodoService todoService;
	
    @PostMapping("/item-add")
    public String addItem() {
        return "Hello. you have valid JWT (JSon Web Token)!";
    }
    
    @PostMapping("/item-list")
    public void getTodayList() {
    	
    }
    
    @GetMapping("/projects")
    public Result<List<ResponseDto>> getProjects() {
    	return todoService.getProjects();
    }
    
    @PostMapping("/master-save")
    public Result<TodoListResponseDto> saveMaster() {
//		return todoService.saveMaster;
    	return null;
    }
}