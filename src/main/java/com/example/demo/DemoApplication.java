package com.example.demo;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
//		System.out.println("##########");
//		Region region = Regions.getCurrentRegion();
//
//		if(region == null) {
//			System.out.println("region is null");
//		}
//		else {
//			System.out.println("region is not null");
//		}
		SpringApplication.run(DemoApplication.class, args);


	}



}
