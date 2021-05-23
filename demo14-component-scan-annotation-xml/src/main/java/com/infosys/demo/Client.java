package com.infosys.demo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		ReportService srv = (ReportService) context.getBean("reportSrv");
		ReportService srv2=(ReportService)context.getBean("repoSrv2");
		
		System.out.println(srv.hashCode()+"          "+srv2.hashCode());
		srv.generateReport();
		context.close();
	}
}
