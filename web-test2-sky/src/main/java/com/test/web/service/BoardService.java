package com.test.web.service;

import java.util.List;

import com.test.web.repository.BoardRepository;
import com.test.web.vo.BoardVO;

public class BoardService {
	private BoardRepository br = new BoardRepository();
	
	public int insertBoard(BoardVO board) {
		return br.insertBoard(board);
	}
	public int updateBoard(BoardVO board) {
		return br.updateBoard(board);
	}
	public int deleteBoard(int biNum) {
		return br.deleteBoard(biNum);
	}
	public List<BoardVO> selectBoards(){
		return br.selectBoards();
	}
	public BoardVO selectBoard(int biNum) {
		return br.selectBoard(biNum);
	}
}
