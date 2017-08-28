package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dto.TCat;
import com.server.dao.mapper.TCatMapper;
import com.service.CatService;
@Service
public class CatServiceImpl implements CatService {
	@Autowired
	private TCatMapper catMapper;
	@Override
	public TCat findOne(Integer id) {
		return catMapper.selectByPrimaryKey(id);
	}

}
