package br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto;

import lombok.*;

import java.math.BigDecimal;

//lombok - gera os setters, getter etc
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {

    private String idProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;

}
