package com.javareact.javafullstack.Repository;


import com.javareact.javafullstack.Entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository; it was used for SQL databases, but we are using MongoDB, so we need to use MongoRepository instead

//public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
//}
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Long> {
}
