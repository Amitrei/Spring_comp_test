package com.amitrei.WireMockTest;

import com.amitrei.WireMockTest.models.AuthorModel;
import com.amitrei.WireMockTest.models.BookModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class WireMockTestApplicationTests {

    private RestTemplate restTemplate = new RestTemplate();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void addBook() {
		BookModel bookModel = new BookModel("moshe",124214, Arrays.asList(new AuthorModel("moshe",12)));
    	ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8081/books",bookModel,String.class);
        BookModel bookModel2 = null;
        try {
             bookModel2 = objectMapper.readValue(response.getBody(),BookModel.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Assertions.assertNotNull(bookModel2);
        Assertions.assertEquals(bookModel2.getName(),bookModel.getName());
    }

    @Test
    public void getBook(){
        List<BookModel> booksFromResponse = restTemplate.getForObject("http://localhost:8081/books", ArrayList.class);
        System.out.println(booksFromResponse);
    }
}

