package br.com.tlf.srcproductcatalogmanagement.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UpdateProduct {
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
