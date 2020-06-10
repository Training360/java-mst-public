package nestedclasses.webshop;

import java.time.LocalDateTime;

public class Product {

    private String name;

    private double price;

    private LocalDateTime from;

    public Product(String name, double price, LocalDateTime from) {
        this.name = name;
        this.price = price;
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
