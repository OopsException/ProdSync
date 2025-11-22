package com.ProdSync.ProdSync.app.product;

import com.ProdSync.ProdSync.app.product.bean.ProductBean;
import com.ProdSync.ProdSync.app.product.param.ProductParam;
import com.ProdSync.ProdSync.app.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

	// Product APIs
    @GetMapping("/{id}")
    public ResponseEntity<ProductBean> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductBean(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductBean>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProductBeans());
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductParam param) {
        productService.submit(param);
        return ResponseEntity.ok("Product created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(@RequestBody ProductParam param) {
        productService.update(param);
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

	// Product Offers APIs

}
