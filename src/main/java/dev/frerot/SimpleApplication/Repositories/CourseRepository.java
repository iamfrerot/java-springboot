package dev.frerot.SimpleApplication.Repositories;

import dev.frerot.SimpleApplication.Entities.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {
}
