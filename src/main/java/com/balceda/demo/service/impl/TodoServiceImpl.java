package com.balceda.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.balceda.demo.entity.Todo;
import com.balceda.demo.repository.TodoRepository;
import com.balceda.demo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Inject
	private TodoRepository todoRepository;

	@Override
	public Optional<Todo> findById(Long id) {
		return todoRepository.findById(id);
	}

	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo update(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

}
