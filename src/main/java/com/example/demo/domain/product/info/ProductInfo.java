package com.example.demo.domain.product.info;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {

    private String name;
    private String description;
    private String subDescription;
}
