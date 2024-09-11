package com.remind.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remind.test.service.GoodsService;
import com.remind.test.util.CMDUtil;
import com.remind.test.vo.GoodsVO;


public class GoodsServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = CMDUtil.getCmd(uri);
		
		if("goods-list".equals(cmd)) {
			GoodsVO goods = new GoodsVO();
			String giNumStr = request.getParameter("giNum");
			String ciName = request.getParameter("giName");
			int giNum;
			if(giNumStr!=null && !giNumStr.equals("")) {
				giNum = Integer.parseInt(giNumStr);
				goods.setGiNum(giNum);
			}
			if(ciName!=null && !ciName.equals("")) {
				goods.setGiName(ciName);
			}
			List<GoodsVO> list = gs.getList(goods);
			request.setAttribute("list", list);
		}else if("goods-view".equals(cmd) || "goods-update".equals(cmd)) {
			String giNumStr = request.getParameter("giNum");
			int giNum = Integer.parseInt(giNumStr);
			GoodsVO goods = gs.getGoods(giNum);
			request.setAttribute("goods", goods);
		} 
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
		rd.forward(request, response);
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CMDUtil.getCmd(request.getRequestURI());
		GoodsVO goods = new GoodsVO();
		
		String giNumStr = request.getParameter("giNum");
		int giNum=0;
		
		if(giNumStr!=null && !"".equals(giNumStr)) {
			giNum = Integer.parseInt(giNumStr);
			goods.setGiNum(giNum);
		}
		String giPriceStr = request.getParameter("giPrice");
		
		int giPrice=0;
		if(giPriceStr!=null && !"".equals(giPriceStr)) {
			giPrice = Integer.parseInt(giPriceStr);
			goods.setGiPrice(giPrice);
		}
		
		goods.setGiName(request.getParameter("giName"));
		goods.setGiDesc(request.getParameter("giDesc"));
		
		String msg = "";
		String uri = "";
		if("goods-insert".equals(cmd)) {
			msg = "등록이 실패하였습니다.";
			uri = "/views/goods/goods-insert";
			int result = gs.insertGoods(goods);
			if(result==1) {
				msg = "등록이 성공하였습니다.";
				uri = "/goods/goods-list";
			}
		}else if("goods-update".equals(cmd)) {
			msg = "수정이 실패하였습니다.";
			uri = "/goods/goods-update?giNum=" + giNumStr;
			int result = gs.updateGoods(goods);
			if(result==1) {
				msg = "수정이 성공하였습니다.";
				uri = "/goods/goods-view?giNum=" + giNumStr;
			}
		}else if("goods-delete".equals(cmd)) {
			msg = "삭제가 실패하였습니다.";
			uri = "/goods/goods-update?giNum=" + giNumStr;
			int result = gs.deleteGoods(goods.getGiNum());
			if(result==1) {
				msg = "삭제가 성공하였습니다.";
				uri = "/goods/goods-list";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("uri", uri);
		RequestDispatcher rd  =request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}
}
