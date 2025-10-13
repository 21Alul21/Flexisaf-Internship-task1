package com.entityProject;

import java.time.LocaldateTime;

import jakarta.persistence.*;

import Lombok.Data;
import Lombok.AllArgsConstructor;
import Lombok.NoArgsConstructor;

// the Lombok annotations (Data, AllArgsContructor and NoArgsConstructor
// are not Hibernate annotations but save the stress of writing getters/etters methods
// and constructors for the entity)

@Entity
@Table(name = "users")
@Data                     
@AllArgsConstructor
@NoArgsConstructor
public class Entity {

    @Id
    @GeneratedValue(strategy = @GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    private String firstName;

    private String LastName;

    private String carModel;

    @Column(length = 200)
    private String primarySchoolAttended;

    @Column(length = 200)
    private String secondarySchoolAttended;
    
    @Column(length = 200)
    private String tetiarySchoolAttended;

    @Column(length = 200)
    private LocaldateTime registeredAt; 
}
