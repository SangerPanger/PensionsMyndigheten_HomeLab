package se.sanger.applicationservice.service;

import se.sanger.applicationservice.dto.CreateApplicationRequest;
import se.sanger.applicationservice.model.ApplicationStatus;
import se.sanger.applicationservice.model.BenefitApplication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/*skapar nytt id, bygger en ansökan, sätter status till DRAFT
sparar den i minnet, returnerar den*/

@Service
public class ApplicationService {

    private final Map<Long, BenefitApplication> storage = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public BenefitApplication create(CreateApplicationRequest request) {
        Long id = idGenerator.getAndIncrement();

        BenefitApplication application = new BenefitApplication(
                id,
                request.getApplicationName(),
                request.getPersonalNumber(),
                request.getBenefitType(),
                ApplicationStatus.DRAFT
        );

        storage.put(id, application);
        return application;
    }

   //hämtar alla sparade ansökningar, gör om dem till en lista, returnerar listan
    public List<BenefitApplication> findAll() {
        return new ArrayList<>(storage.values());
    }

    //Säger till om det det blivit fel och ID inte hittas.
    public BenefitApplication findById(Long id) {
        BenefitApplication application = storage.get(id);
        if (application == null) {
            throw new NoSuchElementException("Application not found: " + id);
        }
        return application;
    }

    //hämtar ansökan via id, kastar fel om den saknas. ändrar status till SUBMITTED
    //returnerar den uppdaterade ansökan
    public BenefitApplication submit(Long id) {
        BenefitApplication application = findById(id);
        application.setStatus(ApplicationStatus.SUBMITTED);
        return application;
    }
}
