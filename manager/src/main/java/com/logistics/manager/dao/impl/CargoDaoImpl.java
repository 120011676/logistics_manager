package com.logistics.manager.dao.impl;

import org.qq120011676.snow.springmvc.dao.impl.BaseDAOImpl;
import org.springframework.stereotype.Service;

import com.logistics.manager.dao.interfaces.ICargoDao;
import com.logistics.manager.entity.CargoEntity;

@Service("cargoDao")
public class CargoDaoImpl extends BaseDAOImpl<CargoEntity> implements ICargoDao {

}
