package com.logistics.manager.dao.impl;

import org.qq120011676.snow.springmvc.dao.impl.BaseDAOImpl;
import org.springframework.stereotype.Repository;

import com.logistics.manager.dao.interfaces.IUserDao;
import com.logistics.manager.entity.UserEntity;

@Repository("userDao")
public class UserDaoImpl extends BaseDAOImpl<UserEntity> implements IUserDao {

}
