package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.entities.Book;
import com.jalvis.SciNet.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/bookapi")
public class BookAPI {
private BookService BService;

@Autowired
BookAPI(BookService service){
    this.BService=service;
}

    @GetMapping("/getbooks")
    public List<Book> books(){
    return BService.getBooks();
    }

    @GetMapping("/getbooksbysubjectid")
    public List<Book> booksBySubject(@RequestParam Long id){
    return BService.getBooksBySubjectId(id);
    }

    @GetMapping("/getbook")
    public Book book(@RequestParam Long id){
        return BService.getBookById(id);
    }
    @PostMapping("/createbook")
    public void createBook(@RequestBody Book book){
        BService.addBook(book);
    }
    @PutMapping("/updatebook")
    public void updateBook(@RequestBody Book book){
    BService.updateBook(book);
    }
    @DeleteMapping("/deletebook")
    public void deleteBook( @RequestParam Long id){
        BService.deleteBook(id);
    }

}
