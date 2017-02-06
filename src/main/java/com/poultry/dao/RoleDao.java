package com.poultry.dao;

import org.springframework.stereotype.Repository;

import com.poultry.dao.entities.Role;
@Repository
public class RoleDao extends BaseDao<Role> {

	@Override
	public Class<Role> getPersistanceClass() {
		// TODO Auto-generated method stub
		return Role.class;
	}
}
