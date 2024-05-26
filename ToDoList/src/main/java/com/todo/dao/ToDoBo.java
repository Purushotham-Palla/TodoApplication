package com.todo.dao;

import java.util.List;

import com.todo.model.ToDo;

public interface ToDoBo {
	
	int save(ToDo td);
	int update(ToDo td);
	int delete(int todoId);
	ToDo  getOneTodo(int todoId);
	ToDo  getOneProject(int projectId);
	List<ToDo > getAll(int projectId);
	

	
}
