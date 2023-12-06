package br.com.tlf.srcproductcatalogmanagement.application.ports.out;

import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.Produto;

import java.util.List;

public interface CatalogoProdutosPortOut {
    List<Produto> recuperarProduto();
}
