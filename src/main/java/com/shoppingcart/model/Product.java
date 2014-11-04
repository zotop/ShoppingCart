package com.shoppingcart.model;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Product representation
 */

public class Product implements Serializable {
    public String id;
    public String name;
    public Double priceIncVat;
    public Double vatPercentage;
    public Double vatAmount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPriceIncVat() {
        return priceIncVat;
    }

    public Double getVatPercentage() {
        return vatPercentage;
    }

    @XmlElement(name="vatAmount")
    public Double getVatAmount() {
        return priceIncVat * vatPercentage;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceIncVat(Double priceIncVat) {
        this.priceIncVat = priceIncVat;
    }

    public void setVatPercentage(Double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }
}
