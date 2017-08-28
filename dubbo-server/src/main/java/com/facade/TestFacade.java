package com.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.common.dto.TCat;
import com.common.facade.ITestFacade;
import com.service.CatService;
@Service(protocol = {"dubbo"}, cluster = "failfast")
public class TestFacade implements ITestFacade{
	private static final Logger LOGGER = LoggerFactory.getLogger(TestFacade.class);
	@Autowired
	private CatService catService;
	@Override
	public TCat getCat(Integer id) {
		LOGGER.info("===getCat start===");
		LOGGER.info("===getCat param===id:"+id);
		if(id!=null){
			return catService.findOne(id);
		}
		//else 抛异常
		return null;
	}

}
