package com.ProdSync.ProdSync.app.supplier;

import com.ProdSync.ProdSync.app.supplier.bean.SupplierBean;
import com.ProdSync.ProdSync.app.supplier.param.SupplierParam;
import com.ProdSync.ProdSync.app.supplier.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/{id}")
    public ResponseEntity<SupplierBean> getSupplier(@PathVariable Integer id) {
        return ResponseEntity.ok(supplierService.getSupplierBean(id));
    }

    @GetMapping
    public ResponseEntity<List<SupplierBean>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.getAllSupplierBeans());
    }

    @PostMapping
    public ResponseEntity<String> createSupplier(@RequestBody SupplierParam param) {
        supplierService.submit(param);
        return ResponseEntity.ok("Supplier created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateSupplier(@RequestBody SupplierParam param) {
        supplierService.update(param);
        return ResponseEntity.ok("Supplier updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Integer id) {
        supplierService.delete(id);
        return ResponseEntity.ok("Supplier deleted successfully");
    }
}
