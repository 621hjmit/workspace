package com.test.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.web.service.UserService;
import com.test.web.vo.UserVO;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService us = new UserService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getRequestURI();// 도메인 빠지고 /user/user-list임.
		int idx = cmd.lastIndexOf("/");
		cmd = cmd.substring(idx+1);
		
		try {
			if("user-list".equals(cmd)) {
				request.setAttribute("users",us.selectUsers());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-list.jsp");
				rd.forward(request, response);
				return;
			}else if("user-view".equals(cmd)) {
				int uiNum = Integer.parseInt(request.getParameter("uiNum"));
				UserVO user = new UserVO();
				//user = request.setAttribute("user",us.selectUser(uiNum));
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-list.jsp");
				rd.forward(request, response);
				return;
			}else if("user-insert".equals(cmd)) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-insert.jsp");
				rd.forward(request, response);
				return;
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		/*
		 * 해당 서블릿의 doGet메서드가 실행되기 위해서 만족해야되는 조건
		 *  1. uri가 반드시 /user 로시작해야한다.
		 *  2. 메서드가 반드시 GET이여야 한다.
		 *  
		 *  /user/user-list
		 *  /user/user-view?nuNum=1
		 *  /user/user-insert
		 */
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();// 도메인 빠지고 /user/user-list임.
		int idx = cmd.lastIndexOf("/");
		cmd = cmd.substring(idx+1);
		UserVO user = new UserVO();
		
		String uiBirth = request.getParameter("uiBirth");
		if(uiBirth != null) {
			uiBirth = uiBirth.replace("-", "");
		}
		String[] uiHobbies = request.getParameterValues("uiHobby");
		if(uiHobbies!=null) {
			String uiHobby = "";
			for(String hobby : uiHobbies) {
				uiHobby += hobby + ",";
			}
			uiHobby = uiHobby.substring(0,uiHobby.length()-1);
			user.setUiHobby(uiHobby);
		}
		
		try {
			if("user-insert".equals(cmd)) {
				int result = us.insertUser(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		String uiDesc = request.getParameter("uiDesc");
		 
		user.setUiName(request.getParameter("uiName"));
		user.setUiId(request.getParameter("uiId"));
		user.setUiPwd(request.getParameter("uiPwd"));
		user.setUiGender(request.getParameter("uiGender"));
		user.setUiGender(request.getParameter("uiDesc"));
		
		try {
			if("user-insert".equals(cmd)) {
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user/user-insert.jsp");
				rd.forward(request, response);
				return;
			}else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		doGet(request, response);
	}

}
