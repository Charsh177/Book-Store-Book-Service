package com.book.controller;

import com.book.dto.BookDTO;
import com.book.dto.ResponseDTO;
import com.book.entity.Book;
import com.book.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookService bookService;

    // Spring AOP implementation Before and After
    // Add New Book Into Bookstore

    @PostMapping("/create")
    public ResponseEntity<String> addBookToRepository(@Valid @RequestBody BookDTO bookDTO) {
        Book newBook = bookService.createBook(bookDTO);
        ResponseDTO responseDTO = new ResponseDTO("New Book Created in Book Store", newBook);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

    // Get All

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllBookData() {
        List<Book> listOfBooks = bookService.getAllBookData();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully :", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // Get All by BookId

    @GetMapping("/getBy/{bookId}")
    public ResponseEntity<String> getBookDataById(@PathVariable int bookId) {
        Book book = bookService.getBookDataById(bookId);
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully by id :", book);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // Delete by id

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<String> deleteRecordById(@PathVariable int bookId) {
        ResponseDTO dto = new ResponseDTO("Book Record deleted successfully", bookService.deleteRecordByToken(bookId));
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // Search by Name

    @CrossOrigin
    @GetMapping(value = "searchByBookName/{name}")
    public ResponseEntity getBookByName(@PathVariable(required = false) Optional<String> name) {
        if (name.isPresent()) {
            List<Book> updateRecord = bookService.getBookByName(name.get());
            ResponseDTO dto = new ResponseDTO(" Book is get successfully by Name", updateRecord);
            return new ResponseEntity(dto, HttpStatus.ACCEPTED);
        } else {
            ResponseDTO dto = new ResponseDTO(" Book is get successfully by Name", new Book());
            return new ResponseEntity(dto, HttpStatus.ACCEPTED);
        }
    }

    // update record by id

    @PutMapping("/updateBookById/{BookId}")
    public ResponseEntity<String> updateRecordById(@PathVariable Integer BookId, @Valid @RequestBody BookDTO bookDTO) {
        Book updateRecord = bookService.updateRecordById(BookId, bookDTO);
        ResponseDTO dto = new ResponseDTO(" Book Record updated successfully by Id", updateRecord);
        return new ResponseEntity(dto, HttpStatus.ACCEPTED);
    }

    // Sorting Books ascending order by price
    @GetMapping("/sortingAscending")
    public ResponseEntity<ResponseDTO> getBooksInAscendingOrder() {
        List<Book> listOfBooks = bookService.sortedListOfBooksInAscendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully :", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // Sorting Books descending order by price
    @GetMapping("/sortingDescending")
    public ResponseEntity<ResponseDTO> getBooksInDescendingOrder() {
        List<Book> listOfBooks = bookService.sortedListOfBooksInDescendingOrder();
        ResponseDTO dto = new ResponseDTO("Data retrieved successfully :", listOfBooks);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // Update Books quantity records
    @PutMapping("/updateQuantity/{id}")
    public ResponseEntity<ResponseDTO> updateQuantity(@PathVariable Integer id, @RequestParam Integer quantity) {
        Book newBook = bookService.updateQuantity(id, quantity);
        ResponseDTO dto = new ResponseDTO("Quantity for book record updated successfully...", newBook);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    // REST TEMPLATE

    @RequestMapping(value = "/listUsers")
    public String getBookList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:8081/user/getAll", HttpMethod.GET, entity, String.class).getBody();
    }
}