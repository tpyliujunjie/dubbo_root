package com.service.impl;

import org.springframework.stereotype.Service;
import com.service.IService;
@Service
public class ServiceImpl implements IService{

	public String Test(String str) {
		
		return "----"+str+"----";
	}

}
