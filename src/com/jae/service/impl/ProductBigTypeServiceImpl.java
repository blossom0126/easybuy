package com.jae.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jae.dao.BaseDAO;
import com.jae.entity.ProductBigType;
import com.jae.service.ProductBigTypeService;
@Service("productBigTypeService")//自动注入
public class ProductBigTypeServiceImpl implements ProductBigTypeService{
    @Resource
	private BaseDAO<ProductBigType> baseDAO;//泛型注入
	@Override
	public List<ProductBigType> findAllBigTypeList() {
		// TODO Auto-generated method stub
		return baseDAO.find(" from ProductBigType");
	}

}
