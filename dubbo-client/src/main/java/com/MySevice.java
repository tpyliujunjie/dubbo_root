package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.facade.ITestFacade;
@Component
public class MySevice {
	@Autowired
    public ITestFacade testFacade;
}
