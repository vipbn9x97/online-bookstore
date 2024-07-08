package com.learnmonilithic.payload.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String email;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;
    private String imageUrl;
}
