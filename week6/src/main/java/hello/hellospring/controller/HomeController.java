package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //우선순위로 인해 먼저 등장
    @GetMapping("/")
    public String home() {
        return "home";
    }
}

