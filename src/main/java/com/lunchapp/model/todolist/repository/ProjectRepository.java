package com.lunchapp.model.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchapp.model.todolist.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {


}
