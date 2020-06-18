package com.ydgk.springmvc;

/**
 * @author kfstart
 * @descrption
 * @create 2020-06-18 15:49
 */
public class Address {

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
