package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.util.Optional;

import java.util.List;

@Controller
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

        @Autowired
        private CartItemRepository cartItemRepository;

        @Autowired
        private ShoppingCartRepository cartRepository;

        @Autowired
        private SpiderRepository spiderRepository;

        @Autowired
        private CustomerRepository customerRepository;

        @GetMapping("/{id}")
        public String showCartItems(@PathVariable("id") Long customerId, Model model) {
                ShoppingCart cart = cartRepository.findByCustomer_CustomerId(customerId)
                                .orElseThrow(() -> new RuntimeException("Cart not found for customer: " + customerId));

                List<CartItem> items = cart.getItems();
                model.addAttribute("items", items);
                model.addAttribute("customerId", customerId);
                return "/cart";
        }

        @PostMapping("/addItem/{customerId}")
        public String addCartItem(
                        @PathVariable Long customerId,
                        @RequestParam Long spiderId,
                        @RequestParam int quantity) {

                // Get or create cart
                ShoppingCart cart = cartRepository.findByCustomer_CustomerId(customerId)
                                .orElseGet(() -> {
                                        ShoppingCart newCart = new ShoppingCart();
                                        Customer customer = customerRepository.findById(customerId)
                                                        .orElseThrow(() -> new RuntimeException("Customer not found"));

                                        newCart.setCustomer(customer);
                                        return cartRepository.save(newCart);
                                });

                Spider spider = spiderRepository.findById(spiderId)
                                .orElseThrow(() -> new RuntimeException("Spider not found"));

                CartItem item = new CartItem();
                item.setCart(cart);
                item.setSpider(spider);
                item.setQuantity(quantity);
                item.setPriceAtAddTime(spider.getPrice());

                cart.getItems().add(item);
                cartRepository.save(cart); // save with item cascade

                return "redirect:/spiders";
        }

        @DeleteMapping("/removeItem/{id}")
        public String removeCartItem(@PathVariable Long id) {
                CartItem cartItem = cartItemRepository.findById(id)
                                .orElseThrow(() -> new RuntimeException("Cart item not found"));

                Long customerId = cartItem.getCart().getCustomer().getCustomerId();

                cartItemRepository.delete(cartItem);

                return "redirect:/shoppingcart/" + customerId;
        }

}
