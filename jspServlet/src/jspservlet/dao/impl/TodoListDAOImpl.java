package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jspservlet.dao.TodoListDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.TodoList;

public class TodoListDAOImpl implements TodoListDAO {
	
	public void addTodo(String todoNo,String todoInfo) throws Exception{
		PreparedStatement pstmt = null;
		String sql = "insert into Todolist(todoNo,todoInfo,isFinished) values(?,?,?)";
		DBConnect dbc = null;  
	
		// 下面是针对数据库的具体操作   
		try{ 
		    // 连接数据库  
			dbc = new DBConnect() ;	
			
			//add new todo
		    pstmt = dbc.getConnection().prepareStatement(sql);
		    pstmt.setString(1,todoNo);
		    pstmt.setString(2,todoInfo);
		    pstmt.setString(3,"0"); //0-not finished, 1-finished
		    pstmt.executeUpdate(); 

		    if(pstmt!=null) 
		    	pstmt.close() ;  
		}catch (SQLException e){   
		    System.out.println(e.getMessage());   
		}finally{   
		    // 关闭数据库连接   
		    dbc.close();   
		}  	
	}
	
	public void updateTodo(String todoNo,String isFinished) throws Exception{
		String sql = "update Todolist set isFinished=? where todoNo =?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;  
	
		// 下面是针对数据库的具体操作   
		try{ 
		    // 连接数据库  
			dbc = new DBConnect() ;	
			
			//update todo
		    pstmt = dbc.getConnection().prepareStatement(sql);
		    pstmt.setString(1,isFinished);//0-not finished, 1-finished
		    pstmt.setString(2,todoNo);
		    pstmt.executeUpdate(); 							
		    
		    if(pstmt!=null) 
		    	pstmt.close();
		}catch (SQLException e){   
		    System.out.println(e.getMessage());   
		}finally{   
		    // 关闭数据库连接   
		    dbc.close();   
		}  	
	}
	
	public TodoList showTodo() throws Exception{
		String sql = "select todoNo,todoInfo,isFinished from Todolist";		
		PreparedStatement pstmt = null;
		DBConnect dbc = null; 
		
		TodoList todoList = new TodoList();
		
		// 下面是针对数据库的具体操作   
		try{ 
			// 连接数据库  
			dbc = new DBConnect() ;	
			pstmt = dbc.getConnection().prepareStatement(sql) ;
			ResultSet rs = pstmt.executeQuery(); 

			ArrayList<String> todoNo = new ArrayList<String>();
			ArrayList<String> todoInfo = new ArrayList<String>();
			ArrayList<String> isFinished = new ArrayList<String>();

			while(rs.next()) {
				todoNo.add(rs.getString("todoNo"));
				todoInfo.add(rs.getString("todoInfo"));
				isFinished.add(rs.getString("isFinished"));	
			}
			
			todoList.setTodoNo(todoNo);	
			todoList.setTodoInfo(todoInfo);	
			todoList.setIsFinished(isFinished);
			
			if(rs!=null) 
				rs.close();		
			if(pstmt!=null) 
				pstmt.close();  
		}catch (SQLException e){   
			System.out.println(e.getMessage());   
		}finally{   
		// 关闭数据库连接   
			dbc.close() ;   
		}
		return todoList;
	}	
}
