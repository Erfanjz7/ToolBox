package com.company.Model;

public class Contacts {
    private String Name;
    private String LastName;
    private String Adress;
    private String Phonenumber;
    public Contacts(String Name , String Lastname , String Adress , String Phonenumber){
        this.Name = Name;
        this.LastName = Lastname;
        this.Adress = Adress;
        this.Phonenumber = Phonenumber;
    }
    public Contacts(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }
}
