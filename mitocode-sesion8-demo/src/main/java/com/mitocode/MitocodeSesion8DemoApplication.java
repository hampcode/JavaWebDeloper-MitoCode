package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.github.javafaker.Faker;
import com.mitocode.entities.Book;
import com.mitocode.entities.Course;
import com.mitocode.entities.Student;
import com.mitocode.entities.StudentIdCard;
import com.mitocode.repository.StudentIdCardRepository;
import com.mitocode.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class MitocodeSesion8DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MitocodeSesion8DemoApplication.class, args);
	}
	
	@Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository,
    		StudentIdCardRepository studentIdCardRepository) {
        return args -> {
        	Faker faker = new Faker();
        	String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@mitocode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            
            student.addBook(
                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));


            student.addBook(
                    new Book("Think and Grow Rich", LocalDateTime.now()));


            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));
            

            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            student.setStudentIdCard(studentIdCard);
            
            student.enrolToCourse(
                    new Course("Computer Science", "IT"));

            student.enrolToCourse(
                    new Course("Amigoscode Sring Data JPA", "IT"));

            studentRepository.save(student);
            
            studentRepository.findById(1L)
            .ifPresent(s -> {
                System.out.println("fetch book lazy...");
                List<Book> books = student.getBooks();
                books.forEach(book -> {
                    System.out.println(
                            s.getFirstName() + " borrowed " + book.getBookName());
                });
            });
            

        };
    }
	
	private void sorting(StudentRepository studentRepository) {
        Sort sort = Sort.by("firstName").ascending()
                .and(Sort.by("age").descending());

        studentRepository.findAll(sort)
                .forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));
    }
	
	private void generateRandomStudents(StudentRepository studentRepository) {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@mitocode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            studentRepository.save(student);
        }
    }

}
