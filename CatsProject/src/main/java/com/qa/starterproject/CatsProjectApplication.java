package com.qa.starterproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatsProjectApplication {
	
	
	// This is a template from Jordan Harrison (changed from puppy controller to cats)
		private List<Cat> cats = new ArrayList<>(); // explain this tomorrow

		@GetMapping("/hello") // listen for a request at /hello
		public String hello() {
			return "Hello, World!"; // sends response
		}

		@PostMapping("/create") // triggered by a POST request to /create
		public ResponseEntity<Cat> createCat(@RequestBody Cat newCat) { // a cat object in the request + response
																				// body
			this.cats.add(newCat);
			Cat responseBody = this.cats.get(this.cats.size() - 1);
			return new ResponseEntity<Cat>(responseBody, HttpStatus.CREATED);
		}

		@GetMapping("/getAll")
		public ResponseEntity<List<Cat>> getCats() {
			return ResponseEntity.ok(this.cats); // unnecessary due to default being 200 anyway
		}

		@GetMapping("/get/{id}") // getcat with id of {id}
		public Cat getCat(@PathVariable Integer id) {
			return this.cats.get(id);
		}

		@PutMapping("/replace/{id}")
		public ResponseEntity<Cat> replaceCat(@PathVariable Integer id, @RequestBody Cat newCat) {

			System.out.println("Replacing cat with id " + id + " with " + newCat);
			return null;
		}

		@DeleteMapping("/remove/{id}")
		public ResponseEntity<?> removeCat(@PathVariable Integer id) {
			System.out.println("Removing cat with id " + id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}