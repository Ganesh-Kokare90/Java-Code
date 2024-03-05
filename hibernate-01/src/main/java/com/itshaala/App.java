package com.itshaala;

import com.itshaala.controller.CourseController;
import com.itshaala.dao.CourseDao;
import com.itshaala.model.Course;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CourseController courseController = new CourseController();

      /*courseController.addCourse(Course.builder()
                        .courseName("Data Science")
                        .cousrePrice(50000)
                .build()); */

       /* courseController.updateCourse(Course.builder()
                        .courseId(52)
                        .courseName("Artificial Intelligence and Data Science")
                        .cousrePrice(96000)
                .build()); */
      /*  courseController.deleteCourse(1); */
        List<Course> courseList = CourseDao.getCourses();
        courseList.forEach(System.out::println);

    }
}

