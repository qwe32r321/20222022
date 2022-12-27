package jspservlet.vo;

import java.util.ArrayList;

public class TodoList {
	private ArrayList<String> todoNo = new ArrayList<String>();
	private ArrayList<String> todoInfo = new ArrayList<String>();
	private ArrayList<String> isFinished = new ArrayList<String>();
	
	public ArrayList<String> getTodoNo() {
		return todoNo;
	}

	public void setTodoNo(ArrayList<String> todoNo) {
		this.todoNo = todoNo;
	}
	
	public ArrayList<String> getTodoInfo() {
		return todoInfo;
	}

	public void setTodoInfo(ArrayList<String> todoInfo) {
		this.todoInfo = todoInfo;
	}

	public ArrayList<String> getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(ArrayList<String> isFinished) {
		this.isFinished = isFinished;
	}
}
