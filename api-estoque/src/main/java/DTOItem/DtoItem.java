package DTOItem;

import com.api_estoque.Entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DtoItem {

    private String nome;
    private int quantidade;
    private double preco;

    public Item tranformandoParaItem() {
        return new Item(0, nome, quantidade, preco);
    }

}
