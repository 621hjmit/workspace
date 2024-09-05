package com.test.web.repository;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.test.web.common.DBCon;
import com.test.web.vo.BoardVO;
import com.test.web.vo.MenuVO;


public class BoardRepository {
	public int insertBoard(BoardVO board) {
		try (Connection con = DBCon.getCon();){
			String sql = "INSERT INTO BOARD_INFO (BI_TITLE, BI_BODY, BI_AUTHOR )VALUES(?,?,?)";
			try (PreparedStatement ps = con.prepareStatement(sql);){
				ps.setString(1, board.getBiTitle());
				ps.setString(2, board.getBiBody());
				ps.setString(3, board.getBiAuthor());
				return ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int updateBoard(BoardVO board) {
		try (Connection con = DBCon.getCon()){
			String sql = "UPDATE BOARD_INFO SET BI_TITLE=?, BI_BODY=? WHERE BI_NUM=?";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.getBiTitle());
				ps.setString(2, board.getBiBody());
				ps.setInt(3, board.getBiNum());
				return ps.executeUpdate();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deleteBoard(int biNum) {
		try (Connection con = DBCon.getCon()){
			String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM =?";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1, biNum);
				return ps.executeUpdate();
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<BoardVO> selectBoards(){
		List<BoardVO> boards = new ArrayList<>();
		try (Connection con = DBCon.getCon()){
			String sql = "SELECT BI_NUM, BI_TITLE, BI_BODY, BI_AUTHOR, CREDAT FROM BOARD_INFO";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				try(ResultSet rs = ps.executeQuery()){
					while(rs.next()) {
						BoardVO board = new BoardVO();
						board.setBiNum(rs.getInt("BI_NUM"));
						board.setBiTitle(rs.getString("BI_TITLE"));
						board.setBiBody(rs.getString("BI_BODY"));
						board.setBiAuthor(rs.getString("BI_AUTHOR"));
						board.setCredat(rs.getString("CREDAT"));
						boards.add(board);
					}
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boards;
	}
	public BoardVO selectBoard(int biNum){
		try (Connection con = DBCon.getCon()){
			String sql = "SELECT BI_NUM, BI_TITLE, BI_BODY, BI_AUTHOR, CREDAT FROM BOARD_INFO WHERE BI_NUM=?";
			try (PreparedStatement ps = con.prepareStatement(sql)){
				ps.setInt(1,biNum);
				try(ResultSet rs = ps.executeQuery()){
					if(rs.next()) {
						BoardVO board = new BoardVO();
						board.setBiNum(rs.getInt("BI_NUM"));
						board.setBiTitle(rs.getString("BI_TITLE"));
						board.setBiBody(rs.getString("BI_BODY"));
						board.setBiAuthor(rs.getString("BI_AUTHOR"));
						board.setCredat(rs.getString("CREDAT"));
						return board;
					}
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
//		BoardRepository br = new BoardRepository();
//		BoardVO board = new BoardVO();
		//int result = br.insertBoard(board);
//		board.setBiNum(1);
//		int result = br.updateBoard(board);
		//int result = br.deleteMenu(4);
//		BoardVO board1 = br.selectBoard(1);
//		System.out.println(board1);
		
	}
}
