package com.balceda.demo.service;

import java.util.List;
import java.util.Optional;

import com.balceda.demo.entity.Todo;

public interface TodoService {

	public Todo save(Todo todo);
	public Todo update(Todo todo);
	public Optional<Todo> findById(Long id);
	public List<Todo> findAll();
	public void delete(Long id);
}
