package com.book.controller;

import com.book.util.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;

/***
 *  Creating RestTemplate methods
 */

@RestController
@RequestMapping("/rest")
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    private TokenUtility tokenUtility;

    @RequestMapping(value = "/books")
    public String getUserList() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/user/getAll", HttpMethod.GET, entity, String.class).getBody();
    }

//    @RequestMapping("/{userId}")
//    public List<Book> getCatalog(@PathVariable("userId") int userId) {
//
//        Book users = restTemplate.getForObject("http://localhost:8081/user/getAll" + userId, Book.class);
//
//        return users.getBookId().map(user -> {
//                    Book book = restTemplate.getForObject("http://localhost:8082/movies/" + userId, Movie.class);
//                    return new Book(movie.getName(), "Desc", user);
//                })
//                .collect(Collectors.toList());
//    }

//    public Book getBook(int bookId, String token) {
//        int userId = tokenUtility.decodeToken(token);
//        UserResponseDTO userResponseDTO = restTemplate.getForObject("http://localhost:8081/user/getAll", );
//    }
}