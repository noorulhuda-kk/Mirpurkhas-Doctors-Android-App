package com.example.finddoctorsinmirpurkhas;

public class Contect_model {
    int img;
    String name, city, Special;
    public Contect_model(int img, String name, String city, String Special){
        this.img = img;
        this.name = name;
        this.city = city;
        this.Special = Special;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }


}
