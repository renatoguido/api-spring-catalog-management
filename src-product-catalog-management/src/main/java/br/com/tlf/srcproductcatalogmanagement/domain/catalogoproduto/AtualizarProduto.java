package br.com.tlf.srcproductcatalogmanagement.domain.catalogoproduto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AtualizarProduto {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidade;
}
