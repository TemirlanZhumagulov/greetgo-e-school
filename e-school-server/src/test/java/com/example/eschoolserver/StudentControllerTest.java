package com.example.eschoolserver;

import com.example.eschoolserver.model.Response;
import com.example.eschoolserver.model.Student;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.client.TestRestTemplate.HttpClientOption;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest extends AbstractTestNGSpringContextTests {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;

    @BeforeMethod
    public void setUp() {
        restTemplate = new TestRestTemplate(HttpClientOption.ENABLE_COOKIES);
        restTemplate.getRestTemplate().setMessageConverters(List.of(new MappingJackson2HttpMessageConverter()));
    }

    @Test
    public void testGetStudents() {
        ResponseEntity<Response> responseEntity = restTemplate.exchange(
                "http://localhost:" + port + "/students/list",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {});
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals("Students retrieved", responseEntity.getBody().getMessage());
    }

    @Test
    public void testAddStudent() {
        Student newStudent = new Student("Temirlan Z.A",20, true, 3.84, 3,"temirlan@gmail.com" );

        ResponseEntity<Response> responseEntity = restTemplate.postForEntity(
                "http://localhost:" + port + "/students/add",
                newStudent,
                Response.class);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals("Student added", responseEntity.getBody().getMessage());
    }
}
