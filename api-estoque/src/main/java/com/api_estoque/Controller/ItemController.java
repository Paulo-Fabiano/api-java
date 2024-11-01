package com.api_estoque.Controller;

import com.api_estoque.Entity.Item;
import com.api_estoque.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository iRespository;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item criarItem = iRespository.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(criarItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> buscarItens() {
        List<Item> getItens = iRespository.findAll();
        return ResponseEntity.ok(getItens);
    }
}
