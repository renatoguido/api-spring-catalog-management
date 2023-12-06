package br.com.tlf.srcproductcatalogmanagement.framework.adapter.out.rest;

import br.com.tlf.srcproductcatalogmanagement.domain.Product;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.AtualizarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.CriarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.Produto;
import br.com.tlf.srcproductcatalogmanagement.framework.adapter.out.client.CatalogoProdutosFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // para a cllasse ser gerenciada e utilizada por outras
public class CatalogoProdutoImpl implements CatalogoProdutosFeignClient {

    @Autowired
    CatalogoProdutosFeignClient catalogoProdutosFeignClient;

    @Override
    public List<Produto> recuperarProdutos() {
        return catalogoProdutosFeignClient.recuperarProdutos();
    }

    @Override
    public Produto recuperarProduto(Product product, String idProduto) {
        return catalogoProdutosFeignClient.recuperarProduto(product, idProduto);
    }

    @Override
    public Produto criarProduto(CriarProduto criarProduto) {
        return catalogoProdutosFeignClient.criarProduto(criarProduto);
    }

    @Override
    public Produto atualizarProduto(String idProduto ,AtualizarProduto atualizarProduto) {
        return catalogoProdutosFeignClient.atualizarProduto(idProduto, atualizarProduto);
    }

    @Override
    public void delete(String idProduto) {
    }
}
