package com.test.web.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.test.web.common.DBCon;
import com.test.web.vo.MenuVO;

public class MenuRepository {
	public int insertMenu(MenuVO menu) {
		try (Connection con = DBCon.getCon();){
			String sql = "INSERT INTO MENU_INFO(MI_NAME, MI_PRICE, MI_PATH) VALUES(?,?,?)";
			try (PreparedStatement ps = con.prepareStatement(sql);){
				ps.setString(1, menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiPath());
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateMenu(MenuVO menu) {
		try (Connection con = DBCon.getCon()){
			String sql = "UPDATE MENU_INFO SET MI_NAME=?, MI_PRICE=? ,MI_PATH=? WHERE MI_NUM =?";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, menu.getMiName());
				ps.setInt(2, menu.getMiPrice());
				ps.setString(3, menu.getMiPath());
				ps.setInt(4,menu.getMiNum());
				return ps.executeUpdate();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteMenu(int miNum) {
		try (Connection con = DBCon.getCon()){
			String sql = "DELETE FROM MENU_INFO WHERE MI_NUM = ?";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, miNum);
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<MenuVO> selectMenus(){
		List<MenuVO> menus = new ArrayList<>();
		try (Connection con = DBCon.getCon()) {
			String sql = "SELECT MI_NUM, MI_NAME, MI_PRICE, MI_PATH FROM MENU_INFO";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				try (ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						MenuVO menu = new MenuVO();
						menu.setMiNum(rs.getInt("MI_NUM"));
						menu.setMiName(rs.getString("MI_NAME"));
						menu.setMiPrice(rs.getInt("MI_PRICE"));
						menu.setMiPath(rs.getString("MI_PATH"));
						menus.add(menu);
					}
				}
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menus;
	}
	public MenuVO selectMenu(int miNum) {
		try(Connection con = DBCon.getCon()) {
			String sql = "SELECT MI_NUM, MI_NAME, MI_PRICE, MI_PATH FROM MENU_INFO WHERE MI_NUM=?";
			try(PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, miNum);
				try (ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						MenuVO menu = new MenuVO();
						menu.setMiNum(rs.getInt("MI_NUM"));
						menu.setMiName(rs.getString("MI_NAME"));
						menu.setMiPrice(rs.getInt("MI_PRICE"));
						menu.setMiPath(rs.getString("MI_PATH"));
						return menu;
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//SELECT CI_NUM, CI_NAME, CI_YEAR FROM CAR_INFO;
	public static void main(String[] args) {

		/*
		MenuRepository mr = new MenuRepository();
		MenuVO menu = new MenuVO();
		menu.setMiName("에스프레소");
		menu.setMiNum(12);
		menu.setMiPrice(2000);
		int result = mr.updateMenu(menu);
		System.out.println(result);
		 * MenuRepository mr = new MenuRepository();
		 
		MenuVO menu = new MenuVO("에스프레소 콘파나",2500);
		int result = mr.insertMenu(menu);
		System.out.println(result);
		
		menu.setMiName("에스프레소");
		menu.setMiNum(12);
		menu.setMiPrice(2000);
		result = mr.updateMenu(menu);
		System.out.println(result);
		
		result = mr.deleteMenu(4);
		System.out.println(result);
		
		List<MenuVO> menus = mr.selectMenus();
		for(MenuVO m :menus) {
			System.out.println(m);
		}
		
		MenuVO m = mr.selectMenu(2);
		System.out.println(m);
		*/
	}
}
