package com.jae.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jae.dao.BaseDAO;
import com.jae.entity.PageBean;
import com.jae.entity.Tag;
import com.jae.service.TagService;
@Service("tagService")//×Ô¶¯±£´æbean
public class TagServiceImpl implements TagService{
@Resource
private BaseDAO<Tag> baseDAO;
@Override
public List<Tag> findTagList() {
	
	StringBuffer hql=new StringBuffer("from Tag");
	return baseDAO.find(hql.toString());
	
}
//	@Override
//	public List<Tag> findTagList(Tag s_Tag, PageBean pageBean) {
//		// TODO Auto-generated method stub
//		
	
}
