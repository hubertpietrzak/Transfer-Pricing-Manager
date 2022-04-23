package pl.coderslab.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.company.Company;
import pl.coderslab.company.CompanyRepository;

import javax.validation.Valid;
import java.util.Collection;

@RequestMapping("/user")
@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public UserController(UserService userService, UserRepository userRepository, CompanyRepository companyRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);
        return "admin";
    }
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "user/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("user",userRepository.findById(id));
        return "user/edit";
    }

    @PostMapping("/update")
    public String update(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "user/edit";
        }
        userRepository.save(user);
        return "redirect:/user/profile";
    }
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "user/profile";
    }

    @ModelAttribute("companies")
    public Collection<Company> companies() {
        return this.companyRepository.findAll();
    }




}
