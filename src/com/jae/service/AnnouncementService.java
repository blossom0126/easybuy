package com.jae.service;

import java.util.List;

import com.jae.entity.Announcement;
import com.jae.entity.PageBean;

public interface AnnouncementService {
public List<Announcement> findAnnouncementList(Announcement s_Announcement,PageBean pageBean);
}
