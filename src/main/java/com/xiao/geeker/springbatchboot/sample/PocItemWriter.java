package com.xiao.geeker.springbatchboot.sample;



import java.util.List;

import org.springframework.batch.item.ItemWriter;

import com.xiao.geeker.springbatchboot.vo.UserInfo;

public class PocItemWriter implements ItemWriter<UserInfo> {

	public void write(List<? extends UserInfo> users) throws Exception {
		
		System.out.println("go into writer....");
		System.out.println(users);
		
	}

	
}
