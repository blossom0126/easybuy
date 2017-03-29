package com.jae.service;

import java.util.List;

import com.jae.entity.PageBean;
import com.jae.entity.Product;

public interface ProductService {
public List<Product> findProductList(Product s_Product,PageBean pageBean);
}
