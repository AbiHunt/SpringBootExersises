package com.qa.starterproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.starterproject.Cat;

@SpringBootApplication
public class Cats {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CatsProjectApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();

		Cat demoCat = new Cat("Mr Fluffy", "Manx", 10);

		String demoCatAsJSON = mapper.writeValueAsString(demoCat);

		System.out.println(demoCatAsJSON);

		Cat backToCat = mapper.readValue(demoCatAsJSON, Cat.class);

		System.out.println(backToCat);
	}

}