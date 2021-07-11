package com.amitrei.WireMockTest;

import com.amitrei.WireMockTest.models.AuthorModel;
import com.amitrei.WireMockTest.models.BookModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.amitrei.WireMockTest.models.BookJson.BOOK_JSON;


@SpringBootTest
class WireMockTestApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @Test
    public void addBook() {


        BookModel bookModel = new BookModel();
        bookModel.setName("moshe2");
        bookModel.setSales(12);

        // Converting Obj to JSON string
        String object = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookModel);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity(object,httpHeaders);
    	ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/books",request,String.class);

// if pojo is serilizable
//     	ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/books",====POJO===,String.class);

        BookModel bookModel2 = null;
       try {
             bookModel2 = objectMapper.readValue(response.getBody(),BookModel.class);
           System.out.println(bookModel2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

//    @Test
//    public void getBook(){
//        List<BookModel> booksFromResponse = restTemplate.getForObject("http://localhost:8081/books", ArrayList.class);
//        System.out.println(booksFromResponse);
//    }
}

