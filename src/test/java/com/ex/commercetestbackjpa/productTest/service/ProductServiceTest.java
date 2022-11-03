package com.ex.commercetestbackjpa.productTest.service;

import com.ex.commercetestbackjpa.domain.dto.product.*;
import com.ex.commercetestbackjpa.domain.entity.product.Product;
import com.ex.commercetestbackjpa.domain.entity.product.ProductDT;
import com.ex.commercetestbackjpa.service.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    public void saveProductTest() {
        ProductRequestDto productRequestDto = new ProductRequestDto();
        List<ProductDTRequestDto> productDTRequestDtoList = new ArrayList<>();
        List<ProductPriceRequestDto> productPriceRequestDtoList = new ArrayList<>();

        // 상품 데이터
        productRequestDto.setProductName("테스트 상품");
        productRequestDto.setKeyword("테스트");
        productRequestDto.setLgroup("10");
        productRequestDto.setMgroup("10");
        productRequestDto.setSgroup("10");
        // 상품 데이터 END

        // 단품 데이터
        ProductDTRequestDto productDTRequestDto1 = new ProductDTRequestDto();
        productDTRequestDto1.setProductDtName("빨강붕어빵");
        productDTRequestDto1.setColorCode("10");
        productDTRequestDto1.setColorName("빨강");
        productDTRequestDto1.setSizeCode("10");
        productDTRequestDto1.setSizeName("중");
        productDTRequestDto1.setImage("이미지");

        ProductDTRequestDto productDTRequestDto2 = new ProductDTRequestDto();
        productDTRequestDto2.setProductDtName("노랑붕어빵");
        productDTRequestDto2.setColorCode("10");
        productDTRequestDto2.setColorName("노랑");
        productDTRequestDto2.setSizeCode("10");
        productDTRequestDto2.setSizeName("대");
        productDTRequestDto2.setImage("이미지");

        productDTRequestDtoList.add(productDTRequestDto1);
        productDTRequestDtoList.add(productDTRequestDto2);
        // 단품 데이터 END

        // 가격 데이터
        ProductPriceRequestDto productPriceRequestDto1 = new ProductPriceRequestDto();
        productPriceRequestDto1.setApplyDate(LocalDateTime.parse("2022-11-12T11:20:10"));
        productPriceRequestDto1.setSalePrice(5000L);
        productPriceRequestDto1.setCostPrice(2000L);
        productPriceRequestDto1.setMargin(productPriceRequestDto1.getSalePrice() - productPriceRequestDto1.getCostPrice());

        ProductPriceRequestDto productPriceRequestDto2 = new ProductPriceRequestDto();
        productPriceRequestDto2.setApplyDate(LocalDateTime.parse("2022-12-25T12:15:30"));
        productPriceRequestDto2.setSalePrice(6000L);
        productPriceRequestDto2.setCostPrice(2000L);
        productPriceRequestDto2.setMargin(productPriceRequestDto2.getSalePrice() - productPriceRequestDto2.getCostPrice());
        // 가격 데이터 END

        productPriceRequestDtoList.add(productPriceRequestDto1);
        productPriceRequestDtoList.add(productPriceRequestDto2);

        productRequestDto.setProductDtRequestDtos(productDTRequestDtoList);
        productRequestDto.setProductPriceRequestDtos(productPriceRequestDtoList);

        productService.saveProduct(productRequestDto);
    }

    @Test
    void 상품명검색() {
        Map<String, Object> map = productService.findProductByProductName("테스트 상품");

        List<ProductResponseDto> list = (List<ProductResponseDto>) map.get("RESULT");

        for(ProductResponseDto pr : list) {
            System.out.println(pr.getProductName());
        }
        //assertThat(list.get(0).getProductName()).isEqualTo("테스트 상품");
    }

    @Test
    void 단품색상변경() {
        ProductDTRequestDto productDTRequestDto = new ProductDTRequestDto();
        productDTRequestDto.setProductDtNo(1L);
        productDTRequestDto.setColorCode("20");
        productDTRequestDto.setColorName("초록");

        productService.updateProductDtColor(productDTRequestDto);

        ProductDtResponseDto  productDtResponseDto = productService.findProductDtByProductDtNo(1L);

        assertThat(productDTRequestDto.getColorCode()).isEqualTo(productDtResponseDto.getColorCode());
    }


}