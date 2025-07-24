package com.Joyce.bookstore;

import com.Joyce.bookstore.repository.BookRepository;
import com.Joyce.bookstore.repository.CustomerRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
@EnableMongoRepositories(basePackages = "com.Joyce.bookstore.repository")
public class Application {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
//                .directory("backend")  // 如果 .env 在 backend 資料夾就寫這
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        // 把 .env 的變數設定成系統屬性，Spring Boot 才能讀到
        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
        System.setProperty("MONGODB_DB", dotenv.get("MONGODB_DB"));
        System.setProperty("NYT_API_KEY", dotenv.get("NYT_API_KEY"));
        System.setProperty("GOOG_API_KEY", dotenv.get("GOOG_API_KEY"));
        System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

//            // save a couple of customers
//            customerRepository.save(new com.Joyce.bookstore.model.Customer("Bob", "Smith"));

            // fetch all customers
//            System.out.println("Customers found with findAll():");
//            System.out.println("-------------------------------");
//            for (Customer customer : customerRepository.findAll()) {
//                System.out.println(customer);
//            }
//            System.out.println();
//            for (Book book : bookRepository.findAll()) {
//                System.out.println(book.title());
//            }




        };
    }

}