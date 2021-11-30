package com.iuh.nhom05.AuthorService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {
    private String id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String area;
}
