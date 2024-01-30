package com.testing.magento.model;

public class Product {
    private String size;
    private String color;
    private int quantity;
    private boolean isAvailable;
    private String price;
    private String name;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product))
            return false;
        Product other = (Product) o;
        boolean areProductsEqual = (this.name.equals(other.name)
//                && this.size.equals(other.size) && this.color.equals(other.color)
                && this.quantity == other.quantity && this.price.equals(other.price));
        return areProductsEqual;
    }
}
