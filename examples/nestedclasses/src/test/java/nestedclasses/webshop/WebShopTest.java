package nestedclasses.webshop;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class WebShopTest {

    WebShop webShop = new WebShop();

    @Before
    public void addProducts() {
        webShop.addProducts(new Product("Winchester", 10, LocalDateTime.of(2013, 1, 1, 10, 12)));
        webShop.addProducts(new Product("SSD", 8, LocalDateTime.of(2014, 1, 1, 10, 12)));
        webShop.addProducts(new Product("Earphone", 12, LocalDateTime.of(2016, 1, 1, 10, 12)));
        webShop.addProducts(new Product("Mouse", 1, LocalDateTime.of(2017, 1, 1, 10, 12)));
        webShop.addProducts(new Product("Phone", 5, LocalDateTime.of(2015, 1, 1, 10, 12)));
    }

    @Test
    public void testOrderByName() {
        assertThat(names(webShop.getProductsOrderByName()),
                equalTo(Arrays.asList("Earphone", "Mouse", "Phone", "SSD", "Winchester")));
    }

    @Test
    public void testOrderByPrice() {
        assertThat(names(webShop.getProductsOrderByPrice()),
                equalTo(Arrays.asList("Mouse", "Phone", "SSD", "Winchester", "Earphone")));
    }

    @Test
    public void testOrderByFrom() {
        assertThat(names(webShop.getProductsOrderByFrom()),
                equalTo(Arrays.asList("Winchester", "SSD", "Phone", "Earphone", "Mouse")));
    }

    private List<String> names(List<Product> products) {
        List<String> names = new ArrayList<>();
        for (Product product: products) {
            names.add(product.getName());
        }
        return names;
    }
}
