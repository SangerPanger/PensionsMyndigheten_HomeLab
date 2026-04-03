package se.sanger.applicationservice.model;
/* Själva metoden för att skicka in en ansökan tatus hänvisar till enum filen
* ApplicationStatus som innehåller olika nivåer av var ansökan befinner sig i processen
* (Tänkt paket påväg till dig: i terminal, skickad, fraktas, levererad */

//Fält för ansökare att fylla i.
public class BenefitApplication {
    private long id;
    private String applicantName;
    private String personalNumber;
    private String benefitType;
    private ApplicationStatus status;

    //Tom metod används av spring för att kunna ska tomma objekt som sen säts.
    public BenefitApplication() {
    }

    public BenefitApplication(long id, String applicantName, String personalNumber, String benefitType, ApplicationStatus status) {
        this.id = id;
        this.applicantName = applicantName;
        this.personalNumber = personalNumber;
        this.benefitType = benefitType;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }
}

/* Exempel på objekt:
BenefitApplication app = new BenefitApplication(
    1L,
    "Sanger",
    "19900101-1234",
    "RETIREMENT",
    ApplicationStatus.DRAFT
);
 */
