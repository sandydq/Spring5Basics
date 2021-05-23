package com.infosys.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ReportService srv = (ReportService)context.getBean("reportService");
		srv.setRecordsPerPage(100);
		srv.generateReport();
		
		context.close();
	
	}

}
