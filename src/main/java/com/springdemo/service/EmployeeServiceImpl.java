package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.EmployeeDao;
import com.springdemo.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeedao;

	@Override
	@Transactional
	public List<EmployeeDto> employeeList() {
		return this.employeedao.employeeList();
	}

}
