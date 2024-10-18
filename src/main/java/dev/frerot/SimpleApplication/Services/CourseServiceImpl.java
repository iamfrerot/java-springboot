package dev.frerot.SimpleApplication.Services;

import dev.frerot.SimpleApplication.Entities.Course;
import dev.frerot.SimpleApplication.Repositories.CourseRepository;
import dev.frerot.SimpleApplication.exceptions.CourseNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

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
        return this.courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException("No course found with courseId:"+courseId));
    }

    @Override
    public Course updateCourse(String courseId, Course course) {
        Course courseToUpdate =this.courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("No course found with courseId:"+courseId));
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
    public Map<String,String> deleteCourse(String courseId) {
        Course courseToDelete =this.courseRepository.findById(courseId).orElseThrow(()->new CourseNotFoundException("No course found with courseId:"+courseId));
        this.courseRepository.delete(courseToDelete);
        return Map.of("Message","Course with CourseId: "+courseId+" Was Deleted successfully");
    }
}
