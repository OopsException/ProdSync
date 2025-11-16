package com.ProdSync.ProdSync.app.supplier.service;

import com.ProdSync.ProdSync.app.supplier.bean.SupplierBean;
import com.ProdSync.ProdSync.app.supplier.domain.Supplier;
import com.ProdSync.ProdSync.app.supplier.param.SupplierParam;
import com.ProdSync.ProdSync.app.supplier.repository.SupplierRepository;
import com.ProdSync.ProdSync.execption.RestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierBean getSupplierBean(Integer id) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> RestException.INVALID("Supplier not found"));

        return toBean(supplier);
    }

    public List<SupplierBean> getAllSupplierBeans() {
        return supplierRepository.findAll()
                .stream().map(this::toBean).toList();
    }

    public void submit(SupplierParam param) {
        Supplier supplier = Supplier.builder()
                .name(param.getName())
                .altName(param.getAltName())
                .shopLink(param.getShopLink())
                .build();

        supplierRepository.save(supplier);
    }

    public void update(SupplierParam param) {
        Supplier supplier = supplierRepository.findById(param.getId())
                .orElseThrow(() -> RestException.INVALID("Supplier not found"));

        supplier.setName(param.getName());
        supplier.setAltName(param.getAltName());
        supplier.setShopLink(param.getShopLink());

        supplierRepository.save(supplier);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }

    private SupplierBean toBean(Supplier supplier) {
        return SupplierBean.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .altName(supplier.getAltName())
                .shopLink(supplier.getShopLink())
                .build();
    }
}
