package com.logistics.manager.service.impl;

import org.qq120011676.snow.springmvc.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.manager.dao.interfaces.ICompanyDao;
import com.logistics.manager.entity.CompanyEntity;
import com.logistics.manager.service.interfaces.ICompanyService;

@Service("companyService")
public class CompanyServiceImpl extends
		BaseServiceImpl<CompanyEntity, ICompanyDao> implements ICompanyService {

	@Autowired
	private ICompanyDao companyDao;

	@Override
	protected ICompanyDao getBaseDAO() {
		return this.companyDao;
	}

}
