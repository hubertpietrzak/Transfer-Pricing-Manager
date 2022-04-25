package pl.coderslab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.documentation.DocumentationRepository;

@Controller
public class HomeController {

    private final DocumentationRepository documentationRepository;

    public HomeController(DocumentationRepository documentationRepository) {
        this.documentationRepository = documentationRepository;
    }

    @GetMapping("/")
    public String hello(){
        return "admin/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("documentation", documentationRepository.findAllByStatusOfDocumentation("W trakcie"));

        model.addAttribute("finishDocs", documentationRepository.countByStatusOfDocumentation("Gotowa"));
        model.addAttribute("inProgress", documentationRepository.countByStatusOfDocumentation("W trakcie"));
        model.addAttribute("nullStatus", documentationRepository.countByStatusOfDocumentation(null));

        return "admin/dashboard";
    }
}
