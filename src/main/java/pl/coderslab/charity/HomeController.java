package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.domain.model.Institution;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository,
                          CategoryRepository categoryRepository,
                          DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.categoryRepository = categoryRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping
    public String homeAction(Model model){

        List<Institution> institutionList = institutionRepository.findAll();
        model.addAttribute("foundation", institutionList);
        model.addAttribute("donationItem", donationRepository.sumItems());
        model.addAttribute("donationBags", donationRepository.sumQuantity());
        return "index";
    }

}
