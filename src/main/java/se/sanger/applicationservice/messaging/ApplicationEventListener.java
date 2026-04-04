package se.sanger.applicationservice.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

    @JmsListener(destination = "${queue.application-submitted}")
    public void onMessage(ApplicationSubmittedEvent event) {
        System.out.println("Processing application: " + event.getApplicationId()
                + ", applicant=" + event.getApplicantName()
                + ", benefitType=" + event.getBenefitType());
    }
}
