package com.capgemini.discover.touchpay;

import java.io.Serializable;

/**
 * Created by Akshay on 27-09-2017.
 */

public class CardDetails implements Serializable {

    String cardNumber;
    String expiryDate;
    String nameOnCard;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    @Override
    public String toString() {
        return "CardDetails" +"\n"+
                " Card Number " + cardNumber + "\n" +
                " Expiry Date " + expiryDate + "\n" +
                " Name On Card " + nameOnCard;

    }
}
