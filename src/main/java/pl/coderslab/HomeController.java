package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String hello(){
        return "admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }
}
