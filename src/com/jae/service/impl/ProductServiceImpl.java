package com.jae.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.stereotype.Service;

import com.jae.dao.BaseDAO;
import com.jae.entity.PageBean;
import com.jae.entity.Product;
import com.jae.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Resource
	private BaseDAO<Product> baseDAO;

	@Override
	public List<Product> findProductList(Product s_Product, PageBean pageBean) {
		// TODO Auto-generated method stub
		List<Object> param = new LinkedList<Object>();
		StringBuffer hql = new StringBuffer("from Product");
		if (s_Product != null) {
			if (s_Product.getSpecialPrice() == 1) {
				hql.append("and specialPrice=1 order by sepcialPriceTime desc");
			}
			if (s_Product.getHot() == 1) {
				hql.append("and hot=1 order by hotTime desc");
			}
		}
		if (pageBean!= null) {
			return baseDAO.find(hql.toString().replaceFirst("and", "where"),param, pageBean);
		} else {
			return null;
		}
	
	}
}
