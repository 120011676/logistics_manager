package com.logistics.manager.dao.impl;

import org.qq120011676.snow.springmvc.dao.impl.BaseDAOImpl;
import org.springframework.stereotype.Repository;

import com.logistics.manager.dao.interfaces.ICompanyDao;
import com.logistics.manager.entity.CompanyEntity;

@Repository("companyDao")
public class CompanyDaoImpl extends BaseDAOImpl<CompanyEntity> implements
		ICompanyDao {

}
