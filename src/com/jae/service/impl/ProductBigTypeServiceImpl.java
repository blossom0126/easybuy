package com.jae.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jae.dao.BaseDAO;
import com.jae.entity.ProductBigType;
import com.jae.service.ProductBigTypeService;
@Service("productBigTypeService")//�Զ�ע��
public class ProductBigTypeServiceImpl implements ProductBigTypeService{
    @Resource
	private BaseDAO<ProductBigType> baseDAO;//����ע��
	@Override
	public List<ProductBigType> findAllBigTypeList() {
		// TODO Auto-generated method stub
		return baseDAO.find(" from ProductBigType");
	}

}
