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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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


    @BeforeEach
    void setUp(){
        courseController = new CourseController();
    }

    @Test
    void getAllCourses() throws Exception {
        Course course = new Course("1.0", "","", "1");

        //all courses es la solucion correcta de lo que se deberia obtener con getAllCourses(), se pone para testear luego
        List<Course> allCourses = Arrays.asList(course);
        Gson gson = new Gson();

        given(service.getAllCourses("1")).willReturn(allCourses);

        mvc.perform(get("/topics/1/courses")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(content().string(gson.toJson(allCourses)));
    }

    @Test
    void getCourse() throws Exception {
        Course course = new Course("1", "","", "1");

        Gson gson = new Gson();

        given(service.getCourse("1")).willReturn(course);

//        mvc.perform(get("/topics/1/courses/1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(gson.toJson(course)));
    }

    @Test
    void addCourse() throws Exception {
        Course course = new Course("1", "","", "1");
        Gson gson = new Gson();

        mvc.perform(post("/topics/1/courses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(course))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content()
                        .string(""))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());//is created?
    }

    @Test
    void updateCourse() throws Exception {

        Course course = new Course("1", "","", "1");
        service.addCourse(course);

        Course changedCourse = new Course("1", "changed","changed", "1");

        Gson gson = new Gson();


        mvc.perform(put("/topics/1/courses/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(changedCourse))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(MockMvcResultMatchers.content()
                        .string(""))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void deleteCourse() throws Exception {
//        mvc.perform(delete("/topics/1/courses/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());


    }
}