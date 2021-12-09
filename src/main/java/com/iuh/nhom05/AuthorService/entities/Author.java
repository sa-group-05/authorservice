package com.iuh.nhom05.AuthorService.entities;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "author")
@ApiModel(description = "Details about the author")
public class Author {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The unique id of the author")
    private int id;
    @ApiModelProperty(notes = "The author's firstName")
    private String firstName;
    @ApiModelProperty(notes = "The author's lastName")
    private String lastName;
    @ApiModelProperty(notes = "The author's dateOfBirth")
    private String dateOfBirth;
    @ApiModelProperty(notes = "The author's area")
    private String area;
}
