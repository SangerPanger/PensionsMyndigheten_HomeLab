package se.sanger.applicationservice.messaging;

import java.io.Serializable;

//Representerar själva händelsen, ansökan inskickad.
//Kan förbättras med tid, var (source) och från vem.
//För JMS

public class ApplicationSubmittedEvent implements Serializable {
    private Long applicationId;
    private String applicantName;
    private String benefitType;

    public ApplicationSubmittedEvent() {}

    public ApplicationSubmittedEvent(Long applicationId, String applicantName, String benefitType) {
        this.applicationId = applicationId;
        this.applicantName = applicantName;
        this.benefitType = benefitType;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }

}
