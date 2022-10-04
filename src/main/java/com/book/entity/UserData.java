package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "user")
@AllArgsConstructor
@ToString
public @Data class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    private String userName;

    private String userPassword;

    private String address;

    private long phoneNumber;

    @Email
    private String email;

    private Boolean verified;

    private Integer otp;

    public UserData() {

    }

}