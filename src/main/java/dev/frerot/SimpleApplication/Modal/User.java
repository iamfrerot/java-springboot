package dev.frerot.SimpleApplication.Modal;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
public class User {
    @Id
    private String userId;
    private String email;
    private String password;
    private int age;
    private String location;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
