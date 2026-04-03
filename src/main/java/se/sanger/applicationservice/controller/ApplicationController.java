package se.sanger.applicationservice.controller;

import se.sanger.applicationservice.dto.CreateApplicationRequest;
import se.sanger.applicationservice.model.BenefitApplication;
import se.sanger.applicationservice.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*klass som tar emot HTTP-anrop och skickar dem vidare till servicen*/

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<BenefitApplication> create(@RequestBody CreateApplicationRequest request) {
        return ResponseEntity.ok(applicationService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<BenefitApplication>> findAll() {
        return ResponseEntity.ok(applicationService.findAll());
    }

    @GetMapping("/{id")
    public ResponseEntity<BenefitApplication> findById(@PathVariable long id) {
        return ResponseEntity.ok(applicationService.findById(id));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<BenefitApplication> submit(@PathVariable long id) {
        return ResponseEntity.ok(applicationService.submit(id));
    }
}
