package com.lunchapp.controller.todolist;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
    @PostMapping("/todo/item-add")
    public String addItem() {
        return "Hello. you have valid JWT (JSon Web Token)!";
    }
    
    @PostMapping("/todo/item-list")
    public void getTodayList() {
    	
    }
}