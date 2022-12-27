package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.TodoListDAO;
import jspservlet.dao.impl.TodoListDAOImpl;
import jspservlet.vo.TodoList;
import net.sf.json.JSONArray;

public class TodoListServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
		
			this.doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		    throws IOException, ServletException{
		
			TodoList todoList = null;	
			String operation = req.getParameter("operation");	
			String todoNo = null;
			String todoInfo = null;
			String isFinished = null;
			
			TodoListDAO dao = new TodoListDAOImpl();   
			  
		     try {
		    	 	switch (Integer.parseInt(operation)) {
						case 0 ://add
								todoNo = req.getParameter("todoNo");
								todoInfo = req.getParameter("todoInfo");
								dao.addTodo(todoNo, todoInfo); 
								break;
						case 1 ://update
								todoNo = req.getParameter("todoNo");
								isFinished = req.getParameter("isFinished");
								dao.updateTodo(todoNo,isFinished); 
								break;								
						case 2 ://show
								todoList = dao.showTodo();
								break;
						default:
			    	 	}	
		    		
		    	 	todoList = dao.showTodo();
					
					try {
				    	res.getWriter().print(JSONArray.fromObject(todoList));
				    	res.getWriter().flush();
				    	res.getWriter().close();
				    } catch(Exception e) {	    	
				    	e.printStackTrace();
				    }
				} catch (Exception e) {
					 //TODO Auto-generated catch block
					e.printStackTrace();
			} 

		 }
	
}
