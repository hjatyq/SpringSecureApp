package ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.repository;

import ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {




}
