package com.javareact.javafullstack;

import lombok.Data;



import javax.persistence.*;

@Data
@Entity
@Table(name = "emp_db")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;
    private String phone;

}

