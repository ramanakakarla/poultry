package com.poultry.dao;

import org.springframework.stereotype.Repository;

import com.poultry.dao.entities.User;
@Repository
public class UserDao extends BaseDao<User> {

	public UserDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<User> getPersistanceClass() {
		// TODO Auto-generated method stub
		return User.class;
	}

}
