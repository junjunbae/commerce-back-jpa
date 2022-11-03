package com.ex.commercetestbackjpa.domain.dto.product;

import com.ex.commercetestbackjpa.domain.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductResponseDto {

    private Long productNo;
    private String productName;
    private String lgroup;
    private String mgroup;
    private String sgroup;
    private String saleFlag;
    private String keyword;
    private int maxBuy;
    private long commentCount;

    private List<ProductDtResponseDto> productDtResponseDtoList;

    private List<ProductPriceResponseDto> productPriceResponseDtoList;

    public ProductResponseDto (Product product) {
        this.productNo = product.getProductNo();
        this.productName = product.getProductName();
        this.lgroup = product.getLgroup();
        this.mgroup = product.getMgroup();
        this.sgroup = product.getSgroup();
        this.saleFlag = product.getSaleFlag();
        this.keyword = product.getKeyword();
        this.maxBuy = product.getMaxBuy();
        this.commentCount = product.getCommentCount();
    }

}
