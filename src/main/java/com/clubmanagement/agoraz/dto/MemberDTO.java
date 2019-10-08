package com.clubmanagement.agoraz.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MemberDTO implements Serializable {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private String street;
    private String licence;
}
