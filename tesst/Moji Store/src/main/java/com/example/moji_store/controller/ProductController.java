package com.example.moji_store.controller;

import com.example.moji_store.model.Cart;
import com.example.moji_store.model.CartItem;
import com.example.moji_store.model.Product;
import com.example.moji_store.service.ProductService;
import com.example.moji_store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cartId") // Sử dụng @SessionAttributes để lưu cartId trong session
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cartId")
    public Long cartId() {
        return null; // Trả về null nếu chưa có cartId trong session
    }

    @GetMapping("")
    public String findAll(Model model) {
        List<Product> list = productService.findAllProducts();
        model.addAttribute("list", list);
        return "home";
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute("cartId") Long cartId, Model model) {
        Optional<Product> optionalProduct = productService.findProductById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            Cart cart;

            // Kiểm tra xem giỏ hàng đã tồn tại hay chưa
            if (cartId == null) {
                cart = new Cart();
                cart = cartService.save(cart); // Lưu giỏ hàng mới vào DB
                cartId = cart.getId(); // Lưu lại ID của giỏ hàng trong session
                model.addAttribute("cartId", cartId); // Cập nhật lại cartId vào model
            } else {
                cart = cartService.findById(cartId).orElse(new Cart());
            }

            // Thêm sản phẩm vào giỏ hàng
            CartItem cartItem = new CartItem(product, 1);
            cartItem.setCart(cart); // Thiết lập mối quan hệ giữa CartItem và Cart
            cart.getItems().add(cartItem); // Thêm sản phẩm vào danh sách items của giỏ hàng
            cartService.save(cart); // Lưu lại giỏ hàng đã cập nhật vào DB
        }
        return "redirect:/"; // Quay lại trang chính sau khi thêm sản phẩm
    }

    @GetMapping("/cart/view")
    public String viewCart(@ModelAttribute("cartId") Long cartId, Model model) {
        if (cartId != null) {
            Optional<Cart> optionalCart = cartService.findById(cartId);
            if (optionalCart.isPresent()) {
                model.addAttribute("items", optionalCart.get().getItems());
                model.addAttribute("total", optionalCart.get().getTotal());
            }
        }
        return "cartView"; // Tên của view để hiển thị giỏ hàng
    }
}