package com.remind.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.remind.test.service.UserService;
import com.remind.test.util.CMDUtil;
import com.remind.test.vo.UserVO;


public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserService cs = new UserService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CMDUtil.getCmd(uri);
		
		if("user-list".equals(cmd)) {
			UserVO user = new UserVO();
			String uiNumStr = request.getParameter("uiNum");
			String uiName = request.getParameter("uiName");
			String uiId = request.getParameter("uiId");
			int uiNum;
			if(uiNumStr!=null && !uiNumStr.equals("")) {
				uiNum = Integer.parseInt(uiNumStr);
				user.setUiNum(uiNum);
			}
			user.setUiName(uiName);
			user.setUiId(uiId);
			List<UserVO> users = cs.getUsers(user);
			request.setAttribute("users", users);
		}else if("user-view".equals(cmd) || "user-update".equals(cmd)) {
			String uiNumStr = request.getParameter("uiNum");
			int uiNum = Integer.parseInt(uiNumStr);
			UserVO user = cs.getUser(uiNum);
			request.setAttribute("user", user);
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
		rd.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CMDUtil.getCmd(request.getRequestURI());
		UserVO user = new UserVO();
		
		String uiNumStr = request.getParameter("uiNum");
		int uiNum=0;
		if(uiNumStr!=null && !"".equals(uiNumStr)) {
			uiNum = Integer.parseInt(uiNumStr);
			user.setUiNum(uiNum);
		}
		user.setUiName(request.getParameter("uiName"));
		user.setUiId(request.getParameter("uiId"));
		user.setUiPwd(request.getParameter("uiPwd"));
		
		String msg = "";
		String uri = "";
		if("user-insert".equals(cmd)) {
			msg = "등록이 실패하였습니다.";
			uri = "/views/user/user-insert";
			int result = cs.insertUser(user);
			if(result==1) {
				msg = "등록이 성공하였습니다.";
				uri = "/user/user-list";
			}
		}else if("user-update".equals(cmd)) {
			msg = "수정이 실패하였습니다.";
			uri = "/user/user-update?uiNum=" + uiNumStr;
			int result = cs.updateUser(user);
			if(result==1) {
				msg = "수정이 성공하였습니다.";
				uri = "/user/user-view?uiNum=" + uiNumStr;
			}
		}else if("user-delete".equals(cmd)) {
			msg = "삭제가 실패하였습니다.";
			uri = "/user/user-update?uiNum=" + uiNumStr;
			int result = cs.deleteUser(user);
			if(result==1) {
				msg = "삭제가 성공하였습니다.";
				uri = "/user/user-list";
			}
		}else if("user-login".equals(cmd)) {
			msg = "로그인 실패하였습니다.";
			uri = "/user/user-login";
			UserVO loginUser = cs.loginUser(user);
			if(loginUser!=null) {
				msg = "로그인 성공하였습니다.";
				uri = "/user/user-list";
				HttpSession session = request.getSession();
				session.setAttribute("user", loginUser);
				msg = loginUser.getUiName() + "님 반갑습니다.";
				uri = "/";
			}
		}else if("user-logout".equals(cmd)) {
			msg = "로그아웃 성공하였습니다.";
			uri = "/user/user-login";
			HttpSession session = request.getSession();
			session.invalidate();
			uri = "/";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("uri", uri);
		RequestDispatcher rd  =request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}
}
