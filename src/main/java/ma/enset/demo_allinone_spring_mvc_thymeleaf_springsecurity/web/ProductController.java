package ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.entities.Product;
import ma.enset.demo_allinone_spring_mvc_thymeleaf_springsecurity.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//****    la solution la plus preferer c'est d'utiliser le constructeur (pas @Autowired)
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }/***
@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/user/index";
    }

//    ***AllProducts
    @GetMapping("/user/index")
    @PreAuthorize("hasRole('USER')")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productsList",products);
        return "products";
    }

//    ***delete
    @PostMapping ("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")

    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
//****Ajouter

    @GetMapping ("/admin/newProduct")
    @PreAuthorize("hasRole('ADMIN')")

    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping("/admin/saveProduct")
    @PreAuthorize("hasRole('ADMIN')")

    public String saveProduct(@Valid Product product, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) return "new-product";
        productRepository.save(product);
        return "redirect:/user/index";
    }

    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping ("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
