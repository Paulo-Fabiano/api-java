package com.api_estoque.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    private String nomeItem;
    private int quantidadeItem;

    public String ToString() {
        return "Nome do Item: "+nomeItem+", Quantidade: "+quantidadeItem;
    }

}
