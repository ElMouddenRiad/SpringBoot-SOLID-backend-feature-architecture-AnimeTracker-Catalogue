package fr.miage.numres.spring_demo_numres_25_26.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserUpdateDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
}
