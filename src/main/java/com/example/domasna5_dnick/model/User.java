package com.example.domasna5_dnick.model;


import lombok.Data;


import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "korisnici")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private boolean isPayed;



    public User (){}
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isPayed = false;
    }

}


