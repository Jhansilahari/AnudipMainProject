package com.anudip.TrainTicketReservationSystemProject.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserLogin {
    @Id
    private String email;
    
    private String password;

    public UserLogin() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
