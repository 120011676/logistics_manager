package com.logistics.manager.dao.impl;

import org.qq120011676.snow.springmvc.dao.impl.BaseDAOImpl;
import org.springframework.stereotype.Repository;

import com.logistics.manager.dao.interfaces.IConsignmentDao;
import com.logistics.manager.entity.ConsignmentEntity;

@Repository("consignmentDao")
public class ConsignmentDaoImpl extends BaseDAOImpl<ConsignmentEntity>
		implements IConsignmentDao {

}
