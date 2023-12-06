package br.com.tlf.srcproductcatalogmanagement.framework.adapter.out.client;

import br.com.tlf.srcproductcatalogmanagement.domain.Product;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.AtualizarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.CriarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @FeignClient(name = "Catalogo-Produto", url ="http://localhost:7777/")
public interface CatalogoProdutosFeignClient {

    @GetMapping(value = "/produtos")
    List<Produto> recuperarProdutos();

    @GetMapping(value = "/produtos/{idProduto}")
    Produto recuperarProduto(@RequestBody Product product, @PathVariable("idProduto") String idProduto);

    @PostMapping(value = "/produtos")
    Produto criarProduto(@RequestBody CriarProduto criarProduto);

    @PutMapping(value ="/produtos/{idProduto}")
    Produto atualizarProduto(@PathVariable ("idProduto") String idProduto, @RequestBody AtualizarProduto atualizarProduto);

    @DeleteMapping(value = "/produtos/{idProduto}")
    void delete(String idProduto);
}
