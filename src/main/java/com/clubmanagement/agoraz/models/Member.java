package com.clubmanagement.agoraz.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "member")
public class Member implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmember")
    private Integer id;
    private String name;
    private String email;
    private String street;
    private String number;
    private String phone;
    private String licence;
}
