package com.remind.test.repository;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.remind.test.config.SqlMybatisConfig;
import com.remind.test.vo.GoodsVO;

public class GoodsRepository {
	public List<GoodsVO> selectList (GoodsVO goods){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("GoodsMapper.selectList",goods);
		}
	}
	
	public GoodsVO selectGoods (int giNum) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()) {
			return session.selectOne("GoodsMapper.selectGoods", giNum);
		}
	}
	
	public int insertGoods (GoodsVO goods) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)) {
			return session.insert("GoodsMapper.insertGoods",goods);
		}
	}
	
	public int updateGoods (GoodsVO goods) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.update("GoodsMapper.updateGoods", goods);
		}
	}
	
	public int deleteGoods (int giNum) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.delete("GoodsMapper.deleteGoods", giNum);
		}
	}
}
