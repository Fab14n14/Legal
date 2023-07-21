package com.favric.legal.Clases;

public class Subsidary {
    private int id ;
    private String name;
    private int internal_id;
    private String address;
    private String contact ;
    private String contact_email;

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

    public int getInternal_id() {
        return internal_id;
    }

    public void setInternal_id(int internal_id) {
        this.internal_id = internal_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public Subsidary() {

    }

    public Subsidary(int id, String name, int internal_id, String address, String contact, String contact_email) {
        this.id = id;
        this.name = name;
        this.internal_id = internal_id;
        this.address = address;
        this.contact = contact;
        this.contact_email = contact_email;
    }
    
}
