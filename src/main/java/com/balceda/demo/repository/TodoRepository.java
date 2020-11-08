package com.balceda.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.balceda.demo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
