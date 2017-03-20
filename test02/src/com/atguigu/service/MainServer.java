package com.atguigu.service;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class MainServer {

	public static void main(String[] args) {
		 JAXRSServerFactoryBean jaxrsServerFactoryBean =new JAXRSServerFactoryBean();
		 jaxrsServerFactoryBean.setAddress("http://192.168.10.252:9999/rest_test");
		 jaxrsServerFactoryBean.setResourceClasses(CustomerService.class);
		 jaxrsServerFactoryBean.create().start();
		 System.out.println("服务启动！！");
	}

}
