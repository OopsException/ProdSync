package com.ProdSync.ProdSync.app.item;

import com.ProdSync.ProdSync.app.item.bean.ItemBean;
import com.ProdSync.ProdSync.app.item.param.ItemParam;
import com.ProdSync.ProdSync.app.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemBean> getItem(@PathVariable Integer id) {
        return ResponseEntity.ok(itemService.getItemBean(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemBean>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItemBeans());
    }

    @PostMapping
    public ResponseEntity<String> createItem(@RequestBody ItemParam param) {
        itemService.submit(param);
        return ResponseEntity.ok("Item created successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateItem(@RequestBody ItemParam param) {
        itemService.update(param);
        return ResponseEntity.ok("Item updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Integer id) {
        itemService.delete(id);
        return ResponseEntity.ok("Item deleted successfully");
    }

}
