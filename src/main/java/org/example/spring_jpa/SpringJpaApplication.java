package org.example.spring_jpa;

import org.example.spring_jpa.repository.UserRepository;
import org.example.spring_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class SpringJpaApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }


}

