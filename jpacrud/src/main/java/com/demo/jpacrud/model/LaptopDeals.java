package com.demo.jpacrud.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LaptopDeals {
    private String brand;
    private String model;
    @Id
    private long upc;
    private long price;
    private long discountedprice;
    private boolean isofferactive;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getUpc() {
        return upc;
    }

    public void setUpc(long upc) {
        this.upc = upc;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDiscountedprice() {
        return discountedprice;
    }

    public void setDiscountedprice(long discountedprice) {
        this.discountedprice = discountedprice;
    }

    public boolean isIsofferactive() {
        return isofferactive;
    }

    public void setIsofferactive(boolean isofferactive) {
        this.isofferactive = isofferactive;
    }

    @Override
    public String toString() {
        return "LaptopDeals{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", upc=" + upc +
                ", price=" + price +
                ", discountedprice=" + discountedprice +
                ", isofferactive=" + isofferactive +
                '}';
    }
}
