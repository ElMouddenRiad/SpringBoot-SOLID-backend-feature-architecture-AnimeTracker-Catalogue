package fr.miage.numres.spring_demo_numres_25_26;

import fr.miage.numres.spring_demo_numres_25_26.entities.User;
import fr.miage.numres.spring_demo_numres_25_26.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringDemoNumres2526Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoNumres2526Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(User.builder()
                    .firstName("Bob")
                    .lastName("Dylan")
                    .dob(new Date())
                    .build());
        };
    }
}
