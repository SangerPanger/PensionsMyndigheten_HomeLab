package se.sanger.applicationservice.dto;
/*Skickar data som kommer användas till BenefitApplication*/

public class CreateApplicationRequest {
    private String applicantName;
    private String personalNumber;
    private String benefitType;

    public CreateApplicationRequest() {}

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(String benefitType) {
        this.benefitType = benefitType;
    }
}
