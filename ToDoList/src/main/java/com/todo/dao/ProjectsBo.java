package com.todo.dao;

import java.util.List;

import com.todo.model.Projects;

public interface ProjectsBo {
	
//	 save(title);
	 int save(Projects pro);
	 
	 int update(Projects pro);
	 int delete(int projectId);
//	 int delete(Projects pro);
//	 Projects  getOne(int id);
	 List<Projects > getAll();
		
		
	 

}
