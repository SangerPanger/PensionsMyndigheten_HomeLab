package se.sanger.applicationservice.service;

import se.sanger.applicationservice.dto.CreateApplicationRequest;
import se.sanger.applicationservice.model.ApplicationStatus;
import se.sanger.applicationservice.model.BenefitApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationServiceTest {

    private final ApplicationService applicationService = new ApplicationService();

    @Test
    void shouldCreateApplicationWithDraftStatus() {
        CreateApplicationRequest request = new CreateApplicationRequest();
        request.setApplicantName("Sanger");
        request.setPersonalNumber("19900101-1234");
        request.setBenefitType("RETIREMENT");

        BenefitApplication created = applicationService.create(request);

        assertNotNull(created.getId());
        assertEquals("Sanger", created.getApplicantName());
        assertEquals(ApplicationStatus.DRAFT, created.getStatus());
    }

    @Test
    void shouldSubmitApplication() {
        CreateApplicationRequest request = new CreateApplicationRequest();
        request.setApplicantName("Sanger");
        request.setPersonalNumber("19900101-1234");
        request.setBenefitType("RETIREMENT");

        BenefitApplication created = applicationService.create(request);
        BenefitApplication submitted = applicationService.submit(created.getId());

        assertEquals(ApplicationStatus.SUBMITTED, submitted.getStatus());
    }
}