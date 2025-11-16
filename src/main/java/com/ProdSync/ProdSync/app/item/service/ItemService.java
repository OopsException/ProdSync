package com.ProdSync.ProdSync.app.item.service;

import com.ProdSync.ProdSync.app.item.bean.ItemBean;
import com.ProdSync.ProdSync.app.item.dao.ItemRepository;
import com.ProdSync.ProdSync.app.item.domain.Item;
import com.ProdSync.ProdSync.app.item.param.ItemParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private void validateDuplicateSerialNumber(Long serialNumber) {
        Optional<Item> existingItem = itemRepository.findBySerialNumber(serialNumber);
        if (existingItem.isPresent())
            throw new RuntimeException("An item with this serial number already exists");
    }

    public ItemBean getItemBean(Integer id) {
        if (id == null || id <= 0)
            throw new RuntimeException("Item ID is required");

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        return ItemBean.builder()
                .name(item.getName())
                .altName(item.getAltName())
                .serialNumber(item.getSerialNumber())
                .price(item.getPrice())
                .weight(item.getWeight())
                .build();
    }

    public List<ItemBean> getAllItemBeans() {
        return itemRepository.findAll().stream()
                .map(item ->
                        ItemBean.builder()
                                .name(item.getName())
                                .altName(item.getAltName())
                                .serialNumber(item.getSerialNumber())
                                .price(item.getPrice())
                                .weight(item.getWeight())
                                .build()).toList();
    }

    public void submit(ItemParam param) {
        validateDuplicateSerialNumber(param.getSerialNumber());

        Item item = Item.builder()
                .name(param.getName())
                .altName(param.getAltName())
                .serialNumber(param.getSerialNumber())
                .price(param.getPrice())
                .weight(param.getWeight())
                .build();

        itemRepository.save(item);
    }

    public void update(ItemParam param) {
        if (param.getId() == null || param.getId() <= 0)
            throw new RuntimeException("Item ID is required");

        Item item = itemRepository.findById(param.getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        if (!item.getSerialNumber().equals(param.getSerialNumber()))
            validateDuplicateSerialNumber(param.getSerialNumber());

        item.setName(param.getName());
        item.setAltName(param.getAltName());
        item.setSerialNumber(param.getSerialNumber());
        item.setPrice(param.getPrice());
        item.setWeight(param.getWeight());

        itemRepository.save(item);
    }

    public void delete(Integer id) {
        if (id == null || id <= 0)
            throw new RuntimeException("Item ID is required");

        itemRepository.deleteById(id);
    }
}
