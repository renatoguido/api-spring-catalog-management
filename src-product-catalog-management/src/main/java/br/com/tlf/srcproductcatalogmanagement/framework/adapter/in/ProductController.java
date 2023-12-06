package br.com.tlf.srcproductcatalogmanagement.framework.adapter.in;

//classe que vai subir os metodos de product

import br.com.tlf.srcproductcatalogmanagement.application.ports.serivce.UseCaseImpl;
import br.com.tlf.srcproductcatalogmanagement.domain.Product;
import br.com.tlf.srcproductcatalogmanagement.domain.CreateProduct;
import br.com.tlf.srcproductcatalogmanagement.domain.UpdateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // sao chamadas rest
@RequestMapping("/product/productCatalogoManagement/jms/v1") // mapeia as requisições que teremos, e somente acessada por este caminho
public class ProductController {
    @Autowired
    UseCaseImpl service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listProducts(){
        var ListaProduct = service.converterProdutoProduct();

        return ResponseEntity.status(200).body(ListaProduct);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> retrieveProduct(@RequestBody Product product, @PathVariable("productId") String productId){
        var ListaProductId = service.recuperarProduto(product, productId);

        return ResponseEntity.status(200).body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProduct createProduct){
        var product = service.createProduct(createProduct);

        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody UpdateProduct updateProduct, @PathVariable("productId") String productId){
        var product = service.atualizarProduto(updateProduct, productId);

        return ResponseEntity.status(200).body(product);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity <Void> deleteProduct(@PathVariable("productId") String productId){
        service.deleteProduct(productId);
        return ResponseEntity.status(204).body(null);
    }
}
