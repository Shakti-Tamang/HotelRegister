package com.microservices.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.opencsv.bean.CsvBindByName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

//named query:
//@NamedQuery(name = "HotelUser.findByAboutMe",query = "select u from HotelUser u where u.aboutMe= :aboutMe")

@NamedQuery(name = "HotelUser.findByAboutMe",query = "select u from HotelUser u where u.aboutMe = ?1")
@Table(name = "users",indexes ={@Index(name = "index_users",columnList = "userId")})
public class HotelUser {

    @Id
    private String userId;

    @CsvBindByName(column = "username")
    String username;

    @CsvBindByName(column = "aboutMe")
    String aboutMe;

    @CsvBindByName(column = "password")
    String password;

    @CsvBindByName(column = "email")
    @Email(message = "must be email")
    String email;

     @CsvBindByName(column = "role")
     private String role;

    @Column(nullable = true)
    Long  imageId;

//    In JPA, @Transient is used to mark a field that should not be persisted to the database. It is
//    typically used for fields that are calculated or temporary and do not need to be stored.
    @Schema(hidden = true)
    @Transient
    List<HotelRatingModel>list=new ArrayList<>();
}
