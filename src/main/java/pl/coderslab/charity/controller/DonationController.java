package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.domain.model.Donation;
import pl.coderslab.charity.domain.repository.CategoryRepository;
import pl.coderslab.charity.domain.repository.DonationRepository;
import pl.coderslab.charity.domain.repository.InstitutionRepository;

@Controller
@RequestMapping("/donation")
@Slf4j
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
        model.addAttribute("donations",new Donation());
        return "donation/form";
    }

    @PostMapping("/confirm")
    public String processAddDonation(Donation donation){

        log.info("zapis {}",donation);
        donationRepository.save(donation);
        return "donation/form-confirmation";
    }
}

// napisać konwertery dla encji category i institution