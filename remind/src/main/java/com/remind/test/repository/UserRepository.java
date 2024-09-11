package com.remind.test.repository;

import java.util.*;

import org.apache.ibatis.session.SqlSession;

import com.remind.test.config.SqlMybatisConfig;
import com.remind.test.vo.UserVO;

public class UserRepository {
	public List<UserVO> selectUsers(UserVO user){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("UserMapper.selectUsers",user);
		}
	}
	
	public UserVO selectUser (int uiNum) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()) {
			return session.selectOne("UserMapper.selectUser", uiNum);
		}
	}

	public UserVO loginUser (UserVO user){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()) {
			return session.selectOne("UserMapper.loginUser", user);
		}
	}
	
	public int insertUser (UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)) {
			return session.insert("UserMapper.insertUser",user);
		}
	}
	
	public int updateUser (UserVO user) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.update("UserMapper.updateUser", user);
		}
	}
	
	public int deleteUser (UserVO user) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.delete("UserMapper.deleteUser", user);
		}
	}
}
