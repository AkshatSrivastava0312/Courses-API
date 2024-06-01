package com.courses.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courses.dao.CourseDao;
import com.courses.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Courses> getCourses() {		
		return courseDao.findAll();
	}


	@Override
	public Courses getCourseById(int courseId) {
//		try {
////		long courseIdLong = Long.parseLong(courseId);
////		long courseIdInt = Integer.parseInt(courseId);
//		@SuppressWarnings("deprecation")
//		Courses entity = courseDao.getById(courseId);
////		Courses entity = courseDao.getMyCourseById(courseIdInt);
////		courseDao.save(entity);
//		return entity;
//		} catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}		
		Courses entity = courseDao.getMyCourseById(courseId);		
		return entity;		
	}


	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}


	@Override
	public Courses updateCourse(Courses course) {		
		courseDao.save(course);		//  uses same method for adding and updating
		return course;		
	}


	@Override
	public Courses deleteCourse(long courseId) {
		Courses entity = courseDao.getReferenceById(courseId);
		courseDao.delete(entity);
		return entity;
	}

}
