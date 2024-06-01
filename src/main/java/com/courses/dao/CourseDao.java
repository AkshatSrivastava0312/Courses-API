package com.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.courses.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{
	
	@Query(value="SELECT * FROM courses c WHERE c.id = :courseId", nativeQuery = true)
	Courses getMyCourseById(int courseId);
	
}
