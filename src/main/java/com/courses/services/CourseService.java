package com.courses.services;

import java.util.List;

import com.courses.entities.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();
	public Courses getCourseById(int courseId);
	public Courses addCourse(Courses course);
	public Courses updateCourse(Courses course);
	public Courses deleteCourse(long courseId);
}
