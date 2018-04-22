package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class DemoController {
	@Autowired
	private DiscoveryClient client;
	@Value("${name}")
	private String name;
	@RequestMapping("discover")
	public  String 	test(){
		List<ServiceInstance> instances = client.getInstances("cloud-simple-service");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getHost());
			System.out.println(serviceInstance.getPort());
		}

		
		return  "cao";
				
	}

	@RequestMapping("say")
	public  String 	say(){
		System.out.println(name);

		
		return  "cao";
				
	}
	
	
	
/*	@RequestMapping("test")
	public  String 	test1(){
		
		System.out.println();

		
		return  "wawa";
				
	}*/
}
