package com.github.kevinnowak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainController {

    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
}
