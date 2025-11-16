package com.ProdSync.ProdSync.app.product.service;

import com.ProdSync.ProdSync.app.item.bean.ItemBean;
import com.ProdSync.ProdSync.app.item.dao.ItemRepository;
import com.ProdSync.ProdSync.app.item.domain.Item;
import com.ProdSync.ProdSync.app.product.bean.ProductBean;
import com.ProdSync.ProdSync.app.product.domain.Product;
import com.ProdSync.ProdSync.app.product.param.ProductParam;
import com.ProdSync.ProdSync.app.product.respository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;

    private void validateDuplicateSerialNumber(Long serialNumber, Integer id) {
        Optional<Product> existingProduct = productRepository.findBySerialNumber(serialNumber);
        if (existingProduct.isPresent() && !existingProduct.get().getId().equals(id))
            throw new RuntimeException("A product with this serial number already exists");
    }

    public ProductBean getProductBean(Integer id) {
        if (id == null || id <= 0)
            throw new RuntimeException("Product ID is required");

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return toBean(product);
    }

    public List<ProductBean> getAllProductBeans() {
        return productRepository.findAll()
                .stream().map(this::toBean).toList();
    }

    public void submit(ProductParam param) {
        validateDuplicateSerialNumber(param.getSerialNumber(), null);

        List<Item> items = itemRepository.findAllById(param.getItemIds());
        if (items.size() != param.getItemIds().size())
            throw new RuntimeException("One or more items not found");

        Product product = Product.builder()
                .name(param.getName())
                .altName(param.getAltName())
                .serialNumber(param.getSerialNumber())
                .price(param.getPrice())
                .stockQuantity(param.getStockQuantity())
                .items(items)
                .build();

        productRepository.save(product);
    }

    public void update(ProductParam param) {
        if (param.getId() == null || param.getId() <= 0)
            throw new RuntimeException("Product ID is required");

        Product product = productRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        validateDuplicateSerialNumber(param.getSerialNumber(), param.getId());

        List<Item> items = itemRepository.findAllById(param.getItemIds());
        if (items.size() != param.getItemIds().size())
            throw new RuntimeException("One or more items not found");

        product.setName(param.getName());
        product.setAltName(param.getAltName());
        product.setSerialNumber(param.getSerialNumber());
        product.setPrice(param.getPrice());
        product.setStockQuantity(param.getStockQuantity());
        product.setItems(items);

        productRepository.save(product);
    }

    public void delete(Integer id) {
        if (id == null || id <= 0)
            throw new RuntimeException("Product ID is required");

        productRepository.deleteById(id);
    }

    private ProductBean toBean(Product product) {
        List<ItemBean> itemBeans = product.getItems().stream()
                .map(i -> ItemBean.builder()
                        .id(i.getId())
                        .name(i.getName())
                        .altName(i.getAltName())
                        .serialNumber(i.getSerialNumber())
                        .price(i.getPrice())
                        .weight(i.getWeight())
                        .build())
                .toList();

        return ProductBean.builder()
                .id(product.getId())
                .name(product.getName())
                .altName(product.getAltName())
                .serialNumber(product.getSerialNumber())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .items(itemBeans)
                .build();
    }
}
