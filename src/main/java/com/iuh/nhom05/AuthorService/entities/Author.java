package com.iuh.nhom05.AuthorService.entities;

import lombok.*;

import java.io.Serializable;

//import javax.persistence.*;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Table(name = "author")
public class Author implements Serializable {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String area;
}
