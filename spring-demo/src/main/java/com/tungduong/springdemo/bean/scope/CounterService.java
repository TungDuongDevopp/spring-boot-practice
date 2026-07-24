package com.tungduong.springdemo.bean.scope;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype") // <--- Đặt là PROTOTYPE
@Service
public class CounterService {

	private static int creationCount = 0;
	private final int instanceId;

	public CounterService() {
		creationCount++;
		this.instanceId = this.hashCode();
		System.out.println("-> [Constructor] Đã tạo instance thứ: " + creationCount);
	}

	public String getInfo() {
		return "Instance ID: " + instanceId;
	}
}
