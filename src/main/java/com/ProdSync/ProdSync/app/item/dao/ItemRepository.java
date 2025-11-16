package com.ProdSync.ProdSync.app.item.dao;

import com.ProdSync.ProdSync.app.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findBySerialNumber(Long serialNumber);
}
