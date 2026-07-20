package com.tungduong.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Controller rest chuyên nhận request HTTP trả trực tiếp dữ liệu
public class HelloController {
    @GetMapping("/") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String hello() {
        return "Hello World";
    }
}
