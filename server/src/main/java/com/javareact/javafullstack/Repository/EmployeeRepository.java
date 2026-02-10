package com.javareact.javafullstack.Repository;

//import org.springframework.data.mongodb.repository.MongoRepository;
import com.javareact.javafullstack.Entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

//public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
//}
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, Long> {
}
