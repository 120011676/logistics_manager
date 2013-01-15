package com.logistics.manager.service.impl;

import org.qq120011676.snow.springmvc.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.manager.dao.interfaces.IUserDao;
import com.logistics.manager.entity.UserEntity;
import com.logistics.manager.service.interfaces.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserEntity, IUserDao>
		implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	protected IUserDao getBaseDAO() {
		return this.userDao;
	}

}
