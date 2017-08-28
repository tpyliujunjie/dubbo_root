package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.common.dto.TCat;

@SpringBootApplication 
@ComponentScan
@ImportResource({"classpath:xml/dubbo-consumer.xml"})
public class App {
	 public static void main(String[] args) {
	        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
	        MySevice bean = run.getBean(MySevice.class);
	        TCat cat = bean.testFacade.getCat(1);
	        System.out.println("--------------:"+cat.getCatName());
	    }
}
