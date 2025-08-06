package Application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {
    @GetMapping("/shop")
    public String shop() {
        return "Shop accessible to everyone!";
    }

    @GetMapping("/orders")
    public String orders() {
        return "Orders accessible to employees!";
    }

    @GetMapping("/payments")
    public String payments() {
        return "Payments accessible to finance department!";
    }
}
