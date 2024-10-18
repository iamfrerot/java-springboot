package dev.frerot.SimpleApplication.Services;

import dev.frerot.SimpleApplication.Entities.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    Course addCourse(Course course);

    List<Course> getAllCourses();

    Course getCourseById(String courseId);

    Course updateCourse(String courseId,Course course);

    Map<String, String> deleteCourse(String courseId);
}
