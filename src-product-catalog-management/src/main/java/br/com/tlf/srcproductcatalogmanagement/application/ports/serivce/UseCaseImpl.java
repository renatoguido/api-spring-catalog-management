package br.com.tlf.srcproductcatalogmanagement.application.ports.serivce;

import br.com.tlf.srcproductcatalogmanagement.domain.CreateProduct;
import br.com.tlf.srcproductcatalogmanagement.domain.Product;
import br.com.tlf.srcproductcatalogmanagement.domain.UpdateProduct;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.AtualizarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.CriarProduto;
import br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto.Produto;
import br.com.tlf.srcproductcatalogmanagement.framework.adapter.out.rest.CatalogoProdutoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//implementação do caso de uso - trasformando produto em product
@Service //classe para ser gerenciada
public class UseCaseImpl {

    @Autowired // injetando as dependencias
    CatalogoProdutoImpl catalogoProdutoFeignClient;

    public List<Product> converterProdutoProduct() // metodo que transforma produto em product
    {
        List<Produto> produtoList = catalogoProdutoFeignClient.recuperarProdutos();
        List<Product> productList = new ArrayList<>();

        produtoList.forEach(produto -> {
            Product product = new Product(produto.getIdProduto(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade());
            productList.add(product);
        });
        return productList;
    }


    public Product recuperarProduto(Product product, String productId){
        Produto produto = new Produto(product.getProductId(), product.getName(), product.getDescripton(), product.getPrice(), product.getQuantity());

        Produto produtoId = catalogoProdutoFeignClient.recuperarProduto(produto, productId);

        Product productOrId = new Product(produtoId.getIdProduto(),produtoId.getNome(), produtoId.getDescricao(), produtoId.getPreco(), produtoId.getQuantidade());

        return productOrId;
    }

    public Product createProduct(CreateProduct createProduct) {

        CriarProduto criarProduto = new CriarProduto(createProduct.getName(), createProduct.getDescription(), createProduct.getPrice(), createProduct.getQuantity());

        var produto = catalogoProdutoFeignClient.criarProduto(criarProduto);

        Product product = new Product(produto.getIdProduto(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade());

        return product;
    }

    public Product atualizarProduto(UpdateProduct updateProduct, String productId){
        AtualizarProduto atualizarProduto = new AtualizarProduto(updateProduct.getName(), updateProduct.getDescription(), updateProduct.getPrice(), updateProduct.getQuantity());

        Produto produtoAtualizar = catalogoProdutoFeignClient.atualizarProduto(productId, atualizarProduto);

        Product product = new Product(produtoAtualizar.getIdProduto(),produtoAtualizar.getNome(), produtoAtualizar.getDescricao(), produtoAtualizar.getPreco(), produtoAtualizar.getQuantidade());

        return product;
    }

    public void deleteProduct(String productId){
        catalogoProdutoFeignClient.delete(productId);
    }
}
