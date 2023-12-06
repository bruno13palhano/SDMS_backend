package com.bruno13palhano.model;

public class Customer {
    private Long id;
    private String name;
    private byte[] photo;
    private String email;
    private String address;
    private String phoneNumber;
    private String timestamp;

    public Customer() {}

    public Customer(Long id, String name, byte[] photo, String email, String address, String phoneNumber,
                    String timestamp) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
