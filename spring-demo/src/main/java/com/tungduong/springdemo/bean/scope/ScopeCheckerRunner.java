
package com.tungduong.springdemo.bean.scope;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component // Đánh dấu đây là một Spring Bean
public class ScopeCheckerRunner implements CommandLineRunner {

	// Spring tự động tiêm ApplicationContext vào lớp này (Giai đoạn 2)
	private final ApplicationContext context;

	public ScopeCheckerRunner(ApplicationContext context) {
		this.context = context;
	}

	// Phương thức này được gọi tự động khi ứng dụng khởi động (Giai đoạn 4)
	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n--- BẮT ĐẦU KIỂM TRA SCOPE ---");

		// Lần 1: Yêu cầu Bean
		System.out.println("Yêu cầu instance 1:");
		CounterService service1 = context.getBean(CounterService.class);
		System.out.println("  -> Service 1 Info: " + service1.getInfo());

		// Lần 2: Yêu cầu Bean
		System.out.println("\nYêu cầu instance 2:");
		CounterService service2 = context.getBean(CounterService.class);
		System.out.println("  -> Service 2 Info: " + service2.getInfo());

		System.out.println("\n--- KẾT QUẢ SO SÁNH ---");
		System.out.println("service1 == service2: " + (service1 == service2));
	}
}