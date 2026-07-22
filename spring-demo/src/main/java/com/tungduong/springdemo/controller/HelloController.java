package com.tungduong.springdemo.controller;

import com.tungduong.springdemo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;


@Controller  // Controller rest chuyên nhận request HTTP trả trực tiếp dữ liệu
public class HelloController {
    @ModelAttribute("name")
    public String name() {
        return "Dương";
    }

    @GetMapping("/") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String showUser(Model model) {
        List<User> userList = Arrays.asList(
                new User("Nguyễn Văn A", "a.nguyen@example.com", "Hà Nội"),
                new User("Trần Thị B", "b.tran@example.com", "TP.HCM"),
                new User("Lê Văn C", "c.le@example.com", "Đà Nẵng")
        );
        model.addAttribute("users",userList);
        return "user/UserManagement";
    }

    @GetMapping("/aboutus") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String about() {
        return "user/about";
    }
    @GetMapping("/contactus") // Khi người dùng gọi get thì spring sẽ gọi hàm này
    public String contact() {
        return "user/contact";
    }


}
