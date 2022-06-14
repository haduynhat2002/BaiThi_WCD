package com.example.thiwcd.entity;

import java.util.HashMap;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private double price;
    private String description;

    public Phone() {
    }

    public Phone(int id, String name, String brand, double price, String description) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }


    public static final class PhoneBuilder {
        private int id;
        private String name;
        private String brand;
        private double price;
        private String description;

        private PhoneBuilder() {
        }

        public static PhoneBuilder aPhone() {
            return new PhoneBuilder();
        }

        public PhoneBuilder id(int id) {
            this.id = id;
            return this;
        }

        public PhoneBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PhoneBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public PhoneBuilder price(double price) {
            this.price = price;
            return this;
        }

        public PhoneBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Phone build() {
            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setDescription(description);
            return phone;
        }
    }
}
