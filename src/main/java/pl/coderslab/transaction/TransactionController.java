package pl.coderslab.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.admin.UserRepository;
import pl.coderslab.company.CompanyRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionRepository transactionRepository;
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;


    public TransactionController(TransactionRepository transactionRepository, CompanyRepository companyRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("companies", companyRepository.findAll());
        return "transaction/add";
    }

    @PostMapping("/add")
    public String transactionAdd(@Valid Transaction transaction, BindingResult result) {
        if (result.hasErrors()) {
            return "transaction/add";
        }
        transactionRepository.save(transaction);
        return "redirect:/transaction/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("transaction", transactionRepository.findAll());
        return "transaction/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("transaction",transactionRepository.findById(id));
        model.addAttribute("companies", companyRepository.findAll());
        model.addAttribute("users", userRepository.findAll());
        return "transaction/edit";
    }

    @PostMapping("/update")
    public String update(@Valid Transaction transaction, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("transaction", transaction);
            return "transaction/edit";
        }
        transactionRepository.save(transaction);
        return "redirect:/transaction/list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTransaction(@PathVariable long id) {
        transactionRepository.deleteById(id);
        return "redirect:/transaction/list";
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


}
