package jspservlet.dao;

import jspservlet.vo.TodoList;

public interface TodoListDAO {
	public void addTodo(String todoNo,String todoInfo) throws Exception;//operation 0
	public void updateTodo(String todoNo,String isFinished) throws Exception;//operation 1
	public TodoList showTodo() throws Exception;//operation 2
}
