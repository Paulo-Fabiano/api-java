package com.api_estoque.Controller;

import DTOItem.DtoItem;
import com.api_estoque.Entity.Item;
import com.api_estoque.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRespository;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody DtoItem itemDto) {
        Item criarItem = itemRespository.save(itemDto.tranformandoParaItem());
        return ResponseEntity.status(HttpStatus.CREATED).body(criarItem);
    }

    @GetMapping
    public ResponseEntity<List<Item>> buscarItens() {
        List<Item> getItens = itemRespository.findAll();
        return ResponseEntity.ok(getItens);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizarItem(@PathVariable Long id, @RequestBody DtoItem itemDto) {
        Optional<Item> itemExistente = itemRespository.findById(id);
        if(itemExistente.isPresent()) {
            Item item = itemExistente.get();
            item.setNomeItem(itemDto.getNome());
            item.setQuantidadeItem(itemDto.getQuantidade());
            item.setPrecoItem(itemDto.getPreco());
            itemRespository.save(item);
            return ResponseEntity.ok(item);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable Long id, @RequestBody DtoItem itemDto) {
        Optional<Item> itemExistente = itemRespository.findById(id);
        if (itemExistente.isPresent()) {
            Item item = itemExistente.get();
            itemRespository.delete(item);
            return ResponseEntity.ok(item);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
