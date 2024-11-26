package dev.frerot.simpleapplication.course.controller;


import dev.frerot.simpleapplication.course.modal.Course;
import dev.frerot.simpleapplication.course.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(summary = "Add A Course", description = "We add the course to DB by providing Course object in request body." +
            " We get the new created Course as response",
            tags = {"Course"})
    @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Course.class), mediaType = "application/json")})
    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return new ResponseEntity<>(this.courseService.addCourse(course), HttpStatus.CREATED);

    }


    @Operation(
            summary = "Get all courses",
            description = "We will get all available courses in database",
            tags = {"Course"}
    )
    @ApiResponse(responseCode = "200",
            content = {@Content(schema = @Schema(implementation = List.class), mediaType = "application/json")})
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(this.courseService.getAllCourses());
    }


    @Operation(
            summary = "Get One course By Id",
            description = "We will get a Single course by It's Id in database",
            tags = {"Course"}
    )

    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Course.class), mediaType = "application/json")})
    @GetMapping("{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable String courseId) {
        return ResponseEntity.ok(this.courseService.getCourseById(courseId));

    }


    @Operation(
            summary = "Updated One course By Id",
            description = "We will Update a Single course by It's Id in database",
            tags = {"Course"}
    )

    @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = Course.class), mediaType = "application/json")})
    @PutMapping("{courseId}")
    public ResponseEntity<Course> updateCourseById(@PathVariable String courseId, @RequestBody Course course) {
        return ResponseEntity.ok(this.courseService.updateCourse(courseId, course));
    }


    @Operation(
            summary = "Delete One course By Id",
            description = "We will Delete a Single course by It's Id in database",
            tags = {"Course"}
    )

    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Map.class), mediaType = "application/json")})
    @DeleteMapping("{courseId}")
    public ResponseEntity<Map<String, String>> deleteCourseById(@PathVariable String courseId) {
        return ResponseEntity.ok(this.courseService.deleteCourse(courseId));
    }

}
