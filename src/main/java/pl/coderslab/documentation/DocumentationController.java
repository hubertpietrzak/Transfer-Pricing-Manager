package pl.coderslab.documentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.company.CompanyRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/documentation")
public class DocumentationController {

    private final DocumentationRepository documentationRepository;
    private final CompanyRepository companyRepository;

    public DocumentationController(DocumentationRepository documentationRepository, CompanyRepository companyRepository) {
        this.documentationRepository = documentationRepository;
        this.companyRepository = companyRepository;
    }



    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("documentation", new Documentation());
        model.addAttribute("companies", companyRepository.findAll());
        return "documentation/add";
    }

    @PostMapping("/add")
    public String documentationAdd(@Valid Documentation documentation, BindingResult result) {
        if (result.hasErrors()) {
            return "documentation/add";
        }
        documentationRepository.save(documentation);
        return "redirect:/documentation/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("documentation", documentationRepository.findAll());
        return "documentation/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("documentation",documentationRepository.findById(id));
        return "documentation/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Documentation documentation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("documentation", documentation);
            return "documentation/edit";
        }
        documentationRepository.save(documentation);
        return "redirect:/documentation/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteDocumentation(@PathVariable long id) {
        documentationRepository.deleteById(id);
        return "redirect:/documentation/list";
    }

    @ModelAttribute("typeOfTransaction")
    public List<String> typeOfTransaction() {
        return Arrays.asList("Transakcje związane z obrotem towarowym – sprzedaż ",
                "Transakcje usługowe – sprzedaż ",
                "Transakcje finansowe – sprzedaż ",
                "Transakcje dotyczące aktywów - sprzedaż",
                "Udostępnienie wartości niematerialnych",
                "Inne transakcje – sprzedaż",
                "Transakcje związane z obrotem towarowym – zakup",
                "Transakcje usługowe – zakup",
                "Transakcje finansowe – zakup",
                "Transakcje dotyczące aktywów - zakup",
                "Korzystanie z wartości niematerialnych",
                "Inne transakcje – zakup",
                "Transakcje dotyczące restrukturyzacji",
                "Transakcje dotyczące restrukturyzacji",
                "Inne transakcje");
    }
    @ModelAttribute("statusOfDocumentation")
    public List<String> statusOfDocumentation() {
        return Arrays.asList("Gotowa",
                "W trakcie");
    }


}
