package com.logistics.manager.service.impl;

import org.qq120011676.snow.springmvc.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistics.manager.dao.interfaces.ICargoDao;
import com.logistics.manager.entity.CargoEntity;
import com.logistics.manager.service.interfaces.ICargoService;

@Service("cargoService")
public class CargoServiceImpl extends BaseServiceImpl<CargoEntity, ICargoDao>
		implements ICargoService {

	@Autowired
	private ICargoDao cargoDao;

	@Override
	protected ICargoDao getBaseDAO() {
		return this.cargoDao;
	}

}
