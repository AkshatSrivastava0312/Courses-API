package com.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courses.entities.Courses;
import com.courses.services.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService courseService;
	
	// get the list of  courses
	@GetMapping("/courses")
	public List<Courses> getCourses() {
		return this.courseService.getCourses();		
	}
	
	// get the course with given ID
	@GetMapping("/courses/{courseId}")
	public Courses getCourseById(@PathVariable int courseId) {
		try {
		Courses c = courseService.getCourseById(courseId);
		return c;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	// add a new course
	@PostMapping(path="/courses", consumes="application/json")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	// update a course
	@PutMapping(path="/courses/{course}", consumes="application/json")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
	// delete a course
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			 return new ResponseEntity<>(HttpStatus.OK);			
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	
}
