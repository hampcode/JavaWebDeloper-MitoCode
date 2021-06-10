package com.mitocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.github.javafaker.Faker;
import com.mitocode.entities.Book;
import com.mitocode.entities.Course;
import com.mitocode.entities.Enrolment;
import com.mitocode.entities.EnrolmentId;
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
        	
        	//Student
        	Faker faker = new Faker();
        	String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@mitocode.edu", firstName, lastName);
            Student student = new Student(
                    firstName,
                    lastName,
                    email,
                    faker.number().numberBetween(17, 55));
            
            //Student-->Book
            student.addBook(
                    new Book("Clean Code", LocalDateTime.now().minusDays(4)));


            student.addBook(
                    new Book("Spring Boot in Action", LocalDateTime.now()));


            student.addBook(
                    new Book("Spring Data JPA", LocalDateTime.now().minusYears(1)));
            

            //Student-->StudentIdCard
            StudentIdCard studentIdCard = new StudentIdCard(
                    "123456789",
                    student);

            student.setStudentIdCard(studentIdCard);
            
            
            //Student-->Enrolment
            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 1L),
                    student,
                    new Course("Computer Science", "IT"),
                    LocalDateTime.now()
            ));

            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Mitocode Spring Data JPA", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));

            student.addEnrolment(new Enrolment(
                    new EnrolmentId(1L, 2L),
                    student,
                    new Course("Mitocode Spring Data JPA", "IT"),
                    LocalDateTime.now().minusDays(18)
            ));

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
}
