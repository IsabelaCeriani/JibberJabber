package io.javabrains.springbootstarter.services;

import io.javabrains.springbootstarter.entities.Course;
import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.repositories.CourseRepository;
import io.javabrains.springbootstarter.repositories.TopicRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;
    CourseService courseService;

    @BeforeEach
    void setUp(){
        courseService = new CourseService(courseRepository);
    }

    @Test
    void getAllCourses() {
        //when
        courseService.getAllCourses("1");
        //then
        verify(courseRepository).findByTopicId("1");
    }

    @Test
    void getCourse() {
        //given
//        Course course = new Course("1.0", "","", "1");
//        courseRepository.save(course);
        //when
        courseService.getCourse("1.0");
        //then
        verify(courseRepository).findById("1.0");
    }

    @Test
    void addCourse() {
        //given
        Course course = new Course("1.0", "","", "1");
        //when
        courseService.addCourse(course);
        //then
        ArgumentCaptor<Course> courseArgumentCaptor  =ArgumentCaptor.forClass(Course.class);
        //verifico que el repositorio fue llamado con save y "capturo" el topic que se guardo
        verify(courseRepository).save(courseArgumentCaptor.capture());
        Course capturedCourse = courseArgumentCaptor.getValue();
        //verifico que el topic que se guardo es el mismo que yo guarde
        Assert.assertEquals(course, capturedCourse);
//        assertThat(capturedTopic).isEqualTo(topic);
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteCourse() {
    }
}