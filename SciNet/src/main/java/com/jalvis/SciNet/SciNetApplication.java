package com.jalvis.SciNet;

import com.jalvis.SciNet.services.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SciNetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SciNetApplication.class, args);
	}

	@Bean	public CommandLineRunner runner(BookService bs){
		return run->{
			/*bs.addBook(bs.createBook("Abiogenesis", "A book about abiogenesis",15.6,"assets/images/products/placeholder.png", true,new Date(), (long)3));
			System.out.println("Book added successfully.");

			/*bs.deleteBook((long)5);
			System.out.println("Deleted successfully");*/
		};
	}

}
