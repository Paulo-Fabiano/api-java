package com.api_estoque.Interface;

public interface ProdutoInterface {

    double calcularTotal();
    String listaItem();

    /*
        O método calcularTotal irá calcular o preço final do produto, somando todos os valores dos itens.
        O método listaItem irá mostrar um array com a lista dos itens que compõem o produto
     */

}
