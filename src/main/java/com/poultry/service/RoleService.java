package com.poultry.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poultry.dao.RoleDao;
import com.poultry.dao.entities.Role;
import com.poultry.vo.RoleVo;
 
 
@Service
public class RoleService {

	public RoleService() {
	}

	@Autowired
	private RoleDao roleDao;
	
	@Transactional
	public boolean saveRole(RoleVo roleVo){
		Role entity = new Role();
		entity.setCode(roleVo.getCode());
		entity.setDescription(roleVo.getDescription());
		roleDao.save(entity);
		return true;
	}
}
