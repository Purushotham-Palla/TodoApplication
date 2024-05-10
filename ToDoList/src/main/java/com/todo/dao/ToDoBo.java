package com.todo.dao;

import java.util.List;

import com.todo.model.ToDo;

public interface ToDoBo {
	
	int save(ToDo td);
	int update(ToDo td);
	int delete(int todoId);
	ToDo  getOne(int todoId);
	ToDo  getOneTodo(int todoId);
	ToDo  getOneProject(int projectId);
	ToDo  get_One(int todoId,int projectId);
	List<ToDo > getAll(int projectId);
	

	
}
