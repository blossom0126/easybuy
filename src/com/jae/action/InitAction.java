package com.jae.action;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.jae.entity.Announcement;
import com.jae.entity.PageBean;
import com.jae.entity.Product;
import com.jae.entity.ProductBigType;
import com.jae.entity.Tag;
import com.jae.service.AnnouncementService;
import com.jae.service.ProductBigTypeService;
import com.jae.service.ProductService;
import com.jae.service.TagService;

@Component
public class InitAction implements ServletContextListener,ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0){}
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent){
		System.out.println("applicationContext"+this);
		ServletContext application=servletContextEvent.getServletContext();
		ProductBigTypeService productBigTypeService =(ProductBigTypeService)applicationContext.getBean("productBigTypeService");
	List<ProductBigType> bigTypeList=productBigTypeService.findAllBigTypeList();
	application.setAttribute("bigTypeList",bigTypeList);
	TagService tagService =(TagService)applicationContext.getBean("tagService");
	
	List<Tag> tagList=tagService.findTagList();
	application.setAttribute("tagList",tagList);
	AnnouncementService announcementService =(AnnouncementService)applicationContext.getBean("announcementService");
	List<Announcement> announcementList=announcementService.findAnnouncementList(null,new PageBean(1, 7));	
	application.setAttribute("announcementList",announcementList);
	
	Product s_Product=new Product();
	s_Product.setSpecialPrice(1);	
	ProductService productService =(ProductService)applicationContext.getBean("productService");
	List<Product> specialPriceroductList=productService.findProductList(s_Product,new PageBean(1, 8));
	application.setAttribute("specialPriceroductList",specialPriceroductList);
	
	s_Product=new Product();
	s_Product.setHot(1);
	List<Product> hotPriceroductList=productService.findProductList(s_Product,new PageBean(1, 8));
	application.setAttribute("hotPriceroductList",hotPriceroductList);
	
	
	}
	@Override 
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("applicationContext"+this);

		// TODO Auto-generated method stub
		this.applicationContext=applicationContext;
	}
}
