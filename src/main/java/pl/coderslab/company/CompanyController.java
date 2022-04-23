package pl.coderslab.company;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.admin.User;
import pl.coderslab.admin.UserRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;


    public CompanyController(CompanyRepository companyRepository, UserRepository userRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("company", new Company());
        return "company/add";
    }

    @PostMapping("/add")
    public String companyAdd(@Valid Company company, BindingResult result) {
        if (result.hasErrors()) {
            return "company/add";
        }
        companyRepository.save(company);
        return "redirect:/company/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("company", companyRepository.findAll());
        return "company/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("company",companyRepository.findById(id));
        return "company/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Company company, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("company", company);
            return "company/edit";
        }
        companyRepository.save(company);
        return "redirect:/company/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCompany(@PathVariable long id) {
        companyRepository.deleteById(id);
        return "redirect:/company/list";
    }
    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {
        Optional<Company> company = companyRepository.findById(id);
        company.ifPresent(value -> model.addAttribute("company", value));
        return "company/details";
    }

    @ModelAttribute("statusOfInventory")
    public List<String> statusOfInventory() {
        return Arrays.asList("Gotowa",
                "W trakcie");
    }
    @ModelAttribute("users")
    public Collection<User> users() {
        return this.userRepository.findAll();
    }


}
