package JavaCartPro.src.model;

public class Payment {
    private String cardNumber;
    private String expirationMonth;
    private String ccv;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }
    public String getCcv() {
        return ccv;
    }

    public void setCardNumber(String number) {
        cardNumber = number;
    }

    public void setExpirationMonth(String month) {
        expirationMonth = month;
    }

    public void setCcv(String number) {
        ccv = number;
    }
}
