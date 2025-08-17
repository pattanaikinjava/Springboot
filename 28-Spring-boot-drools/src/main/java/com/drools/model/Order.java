package com.drools.model;

import java.util.Objects;

public class Order
{
    private String orderName;
    private String cardType;
    private Integer orderDiscount;
    private Integer orderPrice;
    private String rulesDecision;

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", orderDiscount=" + orderDiscount +
                ", orderPrice=" + orderPrice +
                ", rulesDecision=" + rulesDecision +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(orderName, order.orderName)
                && Objects.equals(cardType, order.cardType)
                && Objects.equals(orderDiscount, order.orderDiscount)
                && Objects.equals(orderPrice, order.orderPrice)
                && Objects.equals(rulesDecision, order.rulesDecision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderName, cardType, orderDiscount, orderPrice,rulesDecision);
    }

    public Order(String orderName, String cardType, Integer orderDiscount, Integer orderPrice, String rulesDecision) {
        this.orderName = orderName;
        this.cardType = cardType;
        this.orderDiscount = orderDiscount;
        this.orderPrice = orderPrice;
        this.rulesDecision = rulesDecision;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Integer getOrderDiscount() {
        return orderDiscount;
    }

    public void setOrderDiscount(Integer orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setRulesDecision(String rulesDecision){
        this.rulesDecision = rulesDecision;
    }
    public String getRulesDecision(){
        return rulesDecision;
    }
}

