package com.poultry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poultry.dao.UserDao;
import com.poultry.dao.entities.User;
import com.poultry.vo.UserVO;

@Repository
public class UserService {

	public UserService() {
	}

	@Autowired
	private UserDao userDao;
	
	public boolean saveUser(UserVO user){
		User entity = new User();
		//entity.setAddress(user.get);
		userDao.save(entity);
		return true;
	}

}
