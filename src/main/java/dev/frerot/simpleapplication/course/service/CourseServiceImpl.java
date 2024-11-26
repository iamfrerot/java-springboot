package dev.frerot.simpleapplication.course.service;

import dev.frerot.simpleapplication.course.exceptions.CourseNotFoundException;
import dev.frerot.simpleapplication.course.modal.Course;
import dev.frerot.simpleapplication.course.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private static final String NOCOURSEFOUNDMESSAGE = "No course found with courseId: ";

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course getCourseById(String courseId) {
        return this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOCOURSEFOUNDMESSAGE + courseId));
    }

    @Override
    public Course updateCourse(String courseId, Course course) {
        this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOCOURSEFOUNDMESSAGE + courseId));
        Course updatedCourse = new Course(courseId,
                course.courseName(),
                course.instructor(),
                course.courseFee(),
                course.duration(),
                course.isCourseLive()
        );
        return this.courseRepository.save(updatedCourse);

    }

    @Override
    public Map<String, String> deleteCourse(String courseId) {
        Course courseToDelete = this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOCOURSEFOUNDMESSAGE + courseId));
        this.courseRepository.delete(courseToDelete);
        return Map.of("Message", "Course with CourseId: " + courseId + " Was Deleted successfully");
    }
}
