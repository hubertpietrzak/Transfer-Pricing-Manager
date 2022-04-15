package pl.coderslab.company;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyRepository companyRepository;


    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
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


}
