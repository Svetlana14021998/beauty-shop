package beauty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import beauty.service.ProcedureService;

@Controller
@RequiredArgsConstructor
public class ProcedureController {
    private final ProcedureService service;

    @GetMapping("/procedures")
    String getProceduresPage(Model model) {
        model.addAttribute("procedures", service.getAllProcedure());
        return "procedures";
    }
}
