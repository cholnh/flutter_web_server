package com.example.demo.domain.product;

import com.example.demo.domain.product.info.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Long idx;
    private LocalDateTime registerDate;
    private LocalDateTime modifyDate;
    private Long idxStore;
    private Integer salePrice;
    private ProductInfo productInfo;
    private String productCategoryTitle;
    private Integer cntLike;
    private Integer cntReply;
    private Integer sequence;

    // images
    private String productImageMainPath;
    private List<String> productImageSubPaths = new ArrayList<>();

    // like
    private Boolean isLike;

    private ProductType productType;

    private Boolean isTempActive;
}
