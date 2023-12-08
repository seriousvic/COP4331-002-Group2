package JavaCartPro.src.model;

/**
 * class that stores a customer's payment information
 */
public class Payment {
    private String cardNumber;
    private String expirationMonth;
    private String ccv;

    /**
     * get function for card number
     * @return credit card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * charge credit card
     * @param amount amount to be charged
     */
    public void chargeCard(double amount) {
        System.out.println("Charging card " + cardNumber + " $" + amount);
    }

    /**
     * get function for expiration date
     * @return expiration date
     */
    public String getExpirationMonth() {
        return expirationMonth;
    }

    /**
     * get function for ccv
     * @return ccv
     */
    public String getCcv() {
        return ccv;
    }

    /**
     * set function for card number
     * @param number credit card number
     */
    public void setCardNumber(String number) {
        cardNumber = number;
    }

    /**
     * set function for expiration month
     * @param month expiration month
     */
    public void setExpirationMonth(String month) {
        expirationMonth = month;
    }

    /**
     * set function for ccv
     * @param number ccv
     */
    public void setCcv(String number) {
        ccv = number;
    }
}
