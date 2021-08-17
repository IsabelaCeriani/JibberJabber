package io.javabrains.springbootstarter.controllers;

import com.google.gson.Gson;
import io.javabrains.springbootstarter.entities.Course;
import io.javabrains.springbootstarter.repositories.CourseRepository;
import io.javabrains.springbootstarter.services.CourseService;
import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.repositories.TopicRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {



    @Autowired
    private MockMvc mvc;

    @MockBean
    private CourseService service;


    private CourseRepository courseRepository ;
    private CourseController courseController;
    private TopicRepository topicRepository;


    @BeforeEach
    void setUp(){
        courseController = new CourseController();
    }

    @Test
    void getAllCourses() throws Exception {
        Topic topic = new Topic("1", "", "");
        Course course = new Course("1.0", "","", "1");
//        topicRepository.save(topic);
//        courseRepository.save(course);

        List<Course> allCourses = Arrays.asList(course);

        Gson gson = new Gson();

        mvc.perform(get("/topics/1/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(content().string(gson.toJson(allCourses)));
    }

    @Test
    void getCourse() {
    }

    @Test
    void addCourse() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteCourse() {
    }
}