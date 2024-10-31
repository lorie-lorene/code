package com.m1_fonda.service_users.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Userbanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String surname;
    private String cni;
    private String password;
    private String  email;
    private int numero;
    public Userbanque(int id, String username, String surname, String cni, String password, String email, int numero) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.cni = cni;
        this.password = password;
        this.email = email;
        this.numero = numero;
    }
    public Userbanque() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getCni() {
        return cni;
    }
    public void setCni(String cni) {
        this.cni = cni;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    

}
