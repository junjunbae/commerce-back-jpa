package com.ex.commercetestbackjpa.productTest;

import com.ex.commercetestbackjpa.domain.entity.product.Product;
import com.ex.commercetestbackjpa.domain.entity.product.dto.ProductRequestDto;
import com.ex.commercetestbackjpa.repository.product.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveProductTest() {
        ProductRequestDto productRequestDto = new ProductRequestDto();

        productRequestDto.setProductName("테스트 상품");
        productRequestDto.setKeyword("테스트");
        productRequestDto.setLgroup("10");
        productRequestDto.setMgroup("10");
        productRequestDto.setSgroup("10");

        productRepository.save(productRequestDto.toEntity());
    }

    public void findProductByProductNo() {

        Optional<Product> product = productRepository.findById(1L);
    }


}
