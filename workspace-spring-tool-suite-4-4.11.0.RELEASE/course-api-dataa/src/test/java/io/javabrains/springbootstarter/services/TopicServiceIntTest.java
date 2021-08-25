package io.javabrains.springbootstarter.services;

import io.javabrains.springbootstarter.entities.Topic;
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

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TopicServiceIntTest {


    @Mock
    private TopicRepository topicRepository;
    TopicService topicService;

    @BeforeEach
    void setUp(){
        topicService = new TopicService(topicRepository);
    }



    @Test
    void canGetAllTopics() {
        //when
        topicService.getAllTopics();
        //then
        verify(topicRepository).findAll();
    }
    @Test
    void canAddTopic() {
        //given
        Topic topic =new Topic("","", 1);
        //when
        topicService.addTopic(topic);
        //then
        ArgumentCaptor<Topic> topicArgumentCaptor  =ArgumentCaptor.forClass(Topic.class);
        //verifico que el repositorio fue llamado con save y "capturo" el topic que se guardo
        verify(topicRepository).save(topicArgumentCaptor.capture());
        Topic capturedTopic = topicArgumentCaptor.getValue();
        //verifico que el topic que se guardo es el mismo que yo guarde
        Assert.assertEquals(topic, capturedTopic);
//        assertThat(capturedTopic).isEqualTo(topic);
    }




}