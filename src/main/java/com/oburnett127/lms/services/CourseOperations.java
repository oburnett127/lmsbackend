package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Course;

import java.util.List;

public interface CourseOperations {

	Course createCourse(Course Course);

	List<Course> getCourses();

	Course getCourse(Integer id);

	Course updateCourse(Course Course);

	void deleteCourse(Integer id);

}