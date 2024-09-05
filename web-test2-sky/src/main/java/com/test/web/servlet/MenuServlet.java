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

import com.test.web.service.MenuService;
import com.test.web.util.CmdUtil;
import com.test.web.vo.MenuVO;

public class MenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MenuService ms = new MenuService();
	private static final String UPLOAD_PATH = "C:\\dev\\workspace\\web-test2-sky\\src\\main\\webapp\\upload\\";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * select, selectOne
		 * car-list, car-view
		 * */
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		if("menu-list".equals(cmd)) {
			List<MenuVO> menus = ms.selectMenus();
			request.setAttribute("menus", menus);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views"+uri+".jsp");
			rd.forward(request, response);
		}else if("menu-view".equals(cmd)||"menu-update".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			MenuVO menu = ms.selectMenu(miNum);
			request.setAttribute("menu", menu);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views"+uri+".jsp");
			rd.forward(request, response);
			return;
		}
	}
	
	static Map<String, String> getMap(List<FileItem> items){
		Map<String, String> param = new HashMap<>();
		try {
			for(FileItem item : items) {
				if(item.isFormField()) {
					param.put(item.getFieldName(), item.getString("UTF-8"));
				}else {
					String fileName = item.getName();
					int idx = fileName.lastIndexOf(".");
					fileName = System.nanoTime() + fileName.substring(idx);
					File f = new File(UPLOAD_PATH + fileName);
					item.write(f);
					param.put(item.getFieldName(),"/upload/"+ fileName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return param;
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * insert, update, delete
		 * car-insert, car-update, car-delete
		 * */
		String uri = request.getRequestURI();
		String cmd = CmdUtil.getCmd(uri);
		
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); //임시저장공간 메모리에 저장.
			factory.setSizeThreshold(1024*1024*1024);
			factory.setRepository(new File(UPLOAD_PATH));
			ServletFileUpload sfu = new ServletFileUpload(factory);
			
			try {
				List<FileItem> items = sfu.parseRequest(request);//그냥 가져올 수 없고 파싱을 한번 해야함. 리스트파일로 만들ㅁ.
				Map<String,String> param = getMap(items);
				MenuVO menu = new MenuVO();
				
				menu.setMiName(param.get("miName"));
				menu.setMiPrice(Integer.parseInt(param.get("miPrice")));
				menu.setMiPath(param.get("miPath"));
				int result;
				String msg="", url="";
				if("menu-insert".equals(cmd)) {
					result = ms.insertMenu(menu);
					msg="메뉴 등록 실패!";
					url="/menu/menu-insert";
					if(result==1) {
						msg = "메뉴 등록 성공~";
						url="/menu/menu-list";
					}
				}else if("menu-update".equals(cmd)) {
					int miNum = Integer.parseInt(param.get("miNum"));
					menu.setMiNum(miNum);
					result = ms.updateMenu(menu);
					msg="메뉴 수정 실패!";
					url="/menu/menu-update?miNum="+miNum;
					if(result==1) {
						msg = "메뉴 수정 성공~";
						url="/menu/menu-view?miNum=" + miNum;
					}
				}
				request.setAttribute("msg", msg);
				request.setAttribute("url", url);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
				rd.forward(request, response);
				
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}else if("menu-delete".equals(cmd)) {
			int miNum = Integer.parseInt(request.getParameter("miNum"));
			int result = ms.deleteMenu(miNum);
			String msg="메뉴 삭제 실패!";
			String url="/menu/menu-view?miNum="+miNum;
			if(result==1) {
				msg = "메뉴 삭제 성공~";
				url="/menu/menu-list";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			rd.forward(request, response);
			return ;
		}
	}

}
