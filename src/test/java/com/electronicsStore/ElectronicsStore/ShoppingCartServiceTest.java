package com.electronicsStore.ElectronicsStore;

import com.electronicsStore.ElectronicsStore.model.Products;
import com.electronicsStore.ElectronicsStore.model.ShoppingCart;
import com.electronicsStore.ElectronicsStore.service.ProductsService;
import com.electronicsStore.ElectronicsStore.service.ShoppingCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.electronicsStore.ElectronicsStore.model.Type.ELB;

@RunWith(SpringRunner.class)
@WebMvcTest(ShoppingCartService.class)
public class ShoppingCartServiceTest {

    @MockBean
    ShoppingCartService shoppingCartService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_create_shoppingCart() throws Exception{
        shoppingCartService.createShoppingCart();

    }
}
