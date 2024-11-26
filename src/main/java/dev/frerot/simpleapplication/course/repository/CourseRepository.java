package dev.frerot.simpleapplication.course.repository;

import dev.frerot.simpleapplication.course.modal.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
}
