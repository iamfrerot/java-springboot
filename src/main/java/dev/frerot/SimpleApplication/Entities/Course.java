package dev.frerot.SimpleApplication.Entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public record Course(@Id String courseId,
                     String courseName,
                     String instructor,
                     double courseFee,
                     String duration,
                     boolean isCourseLive
) {

}
