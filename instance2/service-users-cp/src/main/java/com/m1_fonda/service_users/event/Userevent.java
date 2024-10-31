package com.m1_fonda.service_users.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Userevent {
    @JsonProperty("username")
    private String username;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("cni")
    private String cni;
    @JsonProperty("password")
    private String password;
    @JsonProperty("email")
    private String  email;
    @JsonProperty("numero")
    private int numero;

}
