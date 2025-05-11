package ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity;

import ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.entities.Product;
import ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class DemoAllInOneSpringMvcThymeleafSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAllInOneSpringMvcThymeleafSpringSecurityApplication.class, args);
    }


    @Bean
      public  CommandLineRunner start(ProductRepository productRepository) {
            return args -> {
                productRepository.save(Product.builder()
                                .name("Vichy")
                                .price(200)
                                .quantity(129)
                                .build());

                productRepository.save(Product.builder()
                        .name("Roche")
                        .price(150)
                        .quantity(100)
                        .build());

                productRepository.save(Product.builder()
                        .name("Essence")
                        .price(100)
                        .quantity(110)
                        .build());

                productRepository.findAll().forEach(p->
                        System.out.println(p.toString()
                        ));

            };
        }

    }
