package org.example.spring_jpa;

import jakarta.transaction.Transactional;
import org.example.spring_jpa.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Transactional
@SpringBootTest
class SpringJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {


    }

}
