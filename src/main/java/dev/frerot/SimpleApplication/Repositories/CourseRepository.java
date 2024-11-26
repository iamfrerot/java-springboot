package dev.frerot.SimpleApplication.Repositories;

import dev.frerot.SimpleApplication.Modal.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
}
