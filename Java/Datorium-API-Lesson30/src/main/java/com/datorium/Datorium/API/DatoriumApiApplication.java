/*
package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatoriumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatoriumApiApplication.class, args);
	}

}
*/

package com.datorium.Datorium.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class DatoriumApiApplication {

	public static void main(String[] args) {
		System.out.println("asd");
		SpringApplication.run(DatoriumApiApplication.class, args);
	}


	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	//http://localhost:8080/ping  it should pong

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name); // "Hello " + name;
	}
	// http://localhost:8080/hello?name=Anete if you want a specific name
	// everything after ? is parameter that we send to backend.

	@GetMapping("/getbook") //http://localhost:8080/getbook
	public Book getbook() {
		var book = new Book();
		book.title = "book title";
		book.author = "book author";

		return book;
	}

	@PostMapping("/postexample")
	public Book addBook(@RequestBody Book book) {
		book.title = book.title.toUpperCase();
		return book;
	}


	/*
	@GetMapping("/draw")
	public int[][] draw(){
		return new int[][]{
				new int[]{0, 0, 0},
				new int[]{1, 0, 0},
				new int[]{1, 0, 0}};
	}
	*/



}