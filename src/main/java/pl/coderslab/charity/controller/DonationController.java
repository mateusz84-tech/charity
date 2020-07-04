package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.model.Donation;
import pl.coderslab.charity.domain.model.Institution;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;

@Controller
@RequestMapping("/donation")
public class DonationController {

    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationController(DonationRepository donationRepository,
                              CategoryRepository categoryRepository,
                              InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/create")
    public String prepareAddDonation(Model model){

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionRepository.findAll());

        return "donation/create";
    }

    @PostMapping("/confirm")
    public String processAddDonation(Donation donation){

        Institution institution = institutionRepository.getInstitutionByName(donation.getInstitution().getName());
        //List<Category> categoryList = categoryRepository.getCategoryByName(donation.getCategory());

        donationRepository.save(donation);

        return "donation/confirm";
    }


}
