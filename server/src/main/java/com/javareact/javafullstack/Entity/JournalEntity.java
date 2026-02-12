package com.javareact.javafullstack.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "journal_entries") 
@Data 
@NoArgsConstructor 
public class JournalEntity {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    @NonNull
    private String content;
    @NonNull
    private Long employeeId;
    private LocalDateTime date;
    
    public JournalEntity(String title, String content, Long employeeId) {
        this.title = title;
        this.content = content;
        this.employeeId = employeeId;
        this.date = LocalDateTime.now();
    }
}