package io.javabrains.springbootstarter.controllers;

import com.google.gson.Gson;
import io.javabrains.springbootstarter.entities.Topic;
import io.javabrains.springbootstarter.repositories.TopicRepository;
import io.javabrains.springbootstarter.services.TopicService;
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
import java.util.Collections;
import java.util.List;


import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@DataJpaTest
//@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(TopicController.class)
class TopicControllerIntTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private TopicService service;


    private TopicRepository topicRepository;
    TopicController topicController;

    @BeforeEach
    void setUp(){
        topicController = new TopicController();
    }

    @Test
    void canGetAllTopics() throws Exception {
        Topic topic = new Topic("", "", 1);

        List<Topic> allTopics = Collections.singletonList(topic);

        given(service.getAllTopics()).willReturn(allTopics);
        Gson gson = new Gson();

        mvc.perform(get("/topics")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
                .andExpect(content().string(gson.toJson(allTopics)));

    }

    @Test
    void getTopic() throws Exception {
        Topic topic = new Topic("", "", 1);
        given(service.getTopic(1)).willReturn(java.util.Optional.of(topic));

        Gson gson = new Gson();


        mvc.perform(get("/topics/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(gson.toJson(topic)));
    }

    @Test
    void addTopic() throws Exception {
        Topic topic = new Topic("", "", 1);
        Gson gson = new Gson();

        mvc.perform(post("/topics")
        .contentType(MediaType.APPLICATION_JSON)
        .content(gson.toJson(topic))
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
        .string(""))
        .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());//is created?
    }




    @Test
    void updateTopic() throws Exception {
        Topic topic = new Topic("", "", 1);
        service.addTopic(topic);

        Topic changedTopic = new Topic("changedName", "changedTopic", 1);
        Gson gson = new Gson();


        mvc.perform(put("/topics/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(changedTopic))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(MockMvcResultMatchers.content()
                .string(""))
                .andDo(MockMvcResultHandlers.print());

//        mvc.perform(get())
    }

    @Test
    void deleteTopic() throws Exception {
        mvc.perform(delete("/topics/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}