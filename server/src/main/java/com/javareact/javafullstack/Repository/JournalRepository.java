package com.javareact.javafullstack.Repository;

import com.javareact.javafullstack.Entity.JournalEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JournalRepository extends MongoRepository<JournalEntity, ObjectId> {
    List<JournalEntity> findByEmployeeId(Long employeeId);
}
