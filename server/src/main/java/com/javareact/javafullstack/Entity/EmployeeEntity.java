package com.javareact.javafullstack.Entity;
import lombok.AllArgsConstructor;
//import java.lang.String;
// import jakarta.persistence.Entity; persistence is used for relational database, but we are using mongodb, so we will use @Document annotation instead of @Entity
// import jakarta.persistence.GeneratedValue; 
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//lombok is used to reduce as a boilerplate code for getter and setter by using the annotation @Getter and @Setter

//@Entity it is used in relational db, it is used to mark a class as a database entity, which means that it will be mapped to a table in the database. It is a JPA annotation that is used to specify that the class is an entity and should be persisted to the database. When you annotate a class with @Entity, it tells the JPA provider (like Hibernate) to create a corresponding table in the database for that class and to manage its persistence.
@Document(collection = "employee") // it is a employee table in the db
@Data //getter, setter, equals, hashcode, tostring are inside this annotation
@NoArgsConstructor // it is used to generate a no-argument constructor for the class, which is required by some frameworks and libraries that use reflection to create instances of the class. It allows you to create an instance of the class without providing any arguments, which can be useful in certain situations, such as when working with serialization or when using dependency injection frameworks.
public class EmployeeEntity {
    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime CreatedAt;
    private LocalDateTime UpdatedAt;


    //getters & setters
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return CreatedAt;
//    }
//    public void setCreatedAt(LocalDateTime CreatedAt) {
//        this.CreatedAt = CreatedAt;
//    }
//    // update date
//    public LocalDateTime getUpdatedAt() {
//        return UpdatedAt;
//    }
//    public void setUpdatedAt(LocalDateTime UpdatedAt) {
//        this.UpdatedAt = UpdatedAt;
//    }
}

