package com.jae.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jae.dao.BaseDAO;
import com.jae.entity.Announcement;
import com.jae.entity.PageBean;
import com.jae.service.AnnouncementService;

@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
	@Resource
	private BaseDAO<Announcement> baseDAO;

	@Override
	public List<Announcement> findAnnouncementList(Announcement s_Announcement, PageBean pageBean) {
		List<Object> param = new LinkedList<Object>();
		StringBuffer hql = new StringBuffer("from Announcement");
		if (pageBean != null) {
			return baseDAO.find(hql.toString(), param, pageBean);
		} else {
			return null;
		}
	}

}
