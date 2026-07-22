package com.tungduong.springdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller  // Controller rest chuyên nhận request HTTP trả trực tiếp dữ liệu
public class HelloController {
    @ModelAttribute("name")
    public String name() {
        return "Dương";
    }

    @GetMapping("/") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String hello() {
        return "html/index";
    }

    @GetMapping("/aboutus") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String about() {
        return "html/about";
    }
    @GetMapping("/contactus") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String contact() {
        return "html/contact";
    }


}
