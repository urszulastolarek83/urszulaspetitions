package com.stolarek.urszulaspetitions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PetitionController {

    private List<Petition> petitions = new ArrayList<>();

    @GetMapping("/create")
    public String createPetition(Model model) {
        return "createPetition"; // Thymeleaf template for creating a petition
    }

    @PostMapping("/create")
    public String savePetition(@RequestParam String title, @RequestParam String description, @RequestParam String creator) {
        petitions.add(new Petition(title, description, creator));
        return "redirect:/view"; // Redirect to view page after saving
    }

    @GetMapping("/view")
    public String viewPetitions(Model model) {
        model.addAttribute("petitions", petitions); // Add petitions to the model
        return "viewPetitions"; // Thymeleaf template for viewing petitions
    }

    // Add more methods for search functionality if needed
}
