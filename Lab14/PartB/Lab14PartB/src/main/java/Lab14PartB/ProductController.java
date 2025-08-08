package Lab14PartB;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    ChatClient chatClient;

    public ProductController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping
    public String getProductsInfo(@RequestParam("message") String message) {
        List<Product> products = productService.listAll();
        return chatClient
                .prompt()
                .user(message)
                .system("To answer the user prompt you need to get data from here: " + products.toString())
                .call()
                .content();

    }
}
