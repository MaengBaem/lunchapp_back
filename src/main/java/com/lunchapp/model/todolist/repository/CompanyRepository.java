package com.lunchapp.model.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lunchapp.model.todolist.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {


}
