package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {
	public static void main(String[] args) {
		SpringApplication.run(Runner.class, args);
		
		// http://localhost:8080/graphiql
	}
}
/*

#SchemaMapping
query{
  allBooks {
    id title pages
    rating{
      star
    }
  }
}

#QueryMapping
query{
  find(id: 1){
    id title pages
    rating{
      star
    }
    author {
      id
      firstName
    }
  }
}

#Mutation
mutation{
  addBook(book: {
    title: "test",
    pages: 200
  }) {
    id title pages
  }
}

*/