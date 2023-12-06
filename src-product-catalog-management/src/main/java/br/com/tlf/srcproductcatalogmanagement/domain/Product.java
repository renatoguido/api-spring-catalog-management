package br.com.tlf.srcproductcatalogmanagement.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

    private String productId;
    private String name;
    private String descripton;
    private BigDecimal price;
    private Integer quantity;


}
