package com.test.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.test.web.service.BoardService;
import com.test.web.service.MenuService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.BoardVO;
import com.test.web.vo.CarVO;


public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardService();
	private static final String UPLOAD_PATH = "C:\\dev\\workspace\\web-test2-sky\\src\\main\\webapp\\upload\\";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		if("board-list".equals(cmd)) {
			List<BoardVO> boards = bs.selectBoards();
			request.setAttribute("boards", boards);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views"+uri+".jsp");
			rd.forward(request, response);
		}else if("board-view".equals(cmd)||"board-update".equals(cmd)) {
			int biNum = Integer.parseInt(request.getParameter("biNum"));
			BoardVO board = bs.selectBoard(biNum);
			request.setAttribute("board", board);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views"+uri+".jsp");
			rd.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		BoardVO board = new BoardVO();
		board.setBiTitle(request.getParameter("biTitle"));
		board.setBiBody(request.getParameter("biBody"));
		board.setBiAuthor(request.getParameter("biAuthor"));
		if("board-insert".equals(cmd)) {
			int result = bs.insertBoard(board);
			String msg="게시물 등록 실패!";
			String url="/views/board/board-insert";
			if(result==1) {
				msg = "게시물 등록 성공~";
				url="/board/board-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return ;
		}
		else if("board-update".equals(cmd)) {
			int biNum = Integer.parseInt(request.getParameter("biNum"));
			board.setBiNum(biNum);
			int result = bs.updateBoard(board);
			String msg="게시글 수정 실패!";
			String url="/board/board-update?biNum="+biNum;
			if(result==1) {
				msg = "게시글 수정 성공~";
				url="/board/board-view?biNum=" + biNum;
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return ;
		}else if("board-delete".equals(cmd)) {
			int biNum = Integer.parseInt(request.getParameter("biNum"));
			int result = bs.deleteBoard(biNum);
			String msg="게시물 삭제 실패!";
			String url="/board/board-view?biNum="+biNum;
			if(result==1) {
				msg = "게시물 삭제 성공~";
				url="/board/board-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return ;
		}
	}
}
