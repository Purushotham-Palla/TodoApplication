package com.todo.dao;

import com.todo.model.Login;

public interface LoginBo {
	Login getLogin(String password,String userName);
	
}
