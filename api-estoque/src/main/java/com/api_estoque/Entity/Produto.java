package com.api_estoque.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
    /*
        Preciso rever a questão do contructor dessa classe
    */
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeProduto;
    private List<Item> itensProduto;
    private double precoProduto;

}