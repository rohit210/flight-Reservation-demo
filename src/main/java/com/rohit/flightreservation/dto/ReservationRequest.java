package com.rohit.flightreservation.dto;
public class ReservationRequest {
    private Long id;
    private String pfirstName;
    private String plastName;
    private String pemail;
    private String pphone;
    private String nameOneTheCard;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPfirstName() {
        return pfirstName;
    }

    public void setPfirstName(String pfirstName) {
        this.pfirstName = pfirstName;
    }

    public String getPlastName() {
        return plastName;
    }

    public void setPlastName(String plastName) {
        this.plastName = plastName;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getNameOneTheCard() {
        return nameOneTheCard;
    }

    public void setNameOneTheCard(String nameOneTheCard) {
        this.nameOneTheCard = nameOneTheCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }
}
