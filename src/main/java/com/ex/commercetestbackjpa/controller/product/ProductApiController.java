package com.ex.commercetestbackjpa.controller.product;

import com.ex.commercetestbackjpa.domain.dto.product.ProductDTO;
import com.ex.commercetestbackjpa.domain.dto.product.ProductDtDTO;
import com.ex.commercetestbackjpa.domain.dto.product.ProductPriceDTO;
import com.ex.commercetestbackjpa.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Api(tags = {"상품조회 및 저장 Controller"})
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @ApiOperation(value = "상품 저장 메소드")
    @PostMapping("/")
    public Long saveProduct (@RequestBody @Valid ProductDTO.Request productRequestDto) {
        return productService.saveProduct(productRequestDto);
    }

    @ApiOperation(value = "상품 단일 조회 메소드")
    @GetMapping("/{productNo}")
    public ProductDTO.Response findProductByProductNo (@PathVariable Long productNo) {
        return productService.findProductByProductNo(productNo);
    }

    @ApiOperation(value = "상품 조회 메소드")
    @GetMapping(value = {"/", "/{option}/{filterValue}"})
    public Map<String, Object> findProductByOptions (@PathVariable String option, @PathVariable String filterValue) {
        return productService.findProductByOptions(option, filterValue);
    }

    @ApiOperation(value = "단품 저장 메소드")
    @PostMapping("/{productNo}/dt")
    public Long saveProductDt(@RequestBody @Valid List<ProductDtDTO.Request> productDTRequestDtoList, @PathVariable Long productNo) {
        return productService.saveProductDt(productDTRequestDtoList, productNo);
    }

    @ApiOperation(value = "단품 변경 메소드")
    @PatchMapping("/{productNo}/dt/update")
    public Long updateProductDtColor(@RequestBody @Valid List<ProductDtDTO.Request> productDTRequestDtoList, @PathVariable Long productNo) {
        return productService.updateProductDt(productDTRequestDtoList, productNo);
    }

    @ApiOperation(value = "가격 변경 메소드")
    @PatchMapping("/{productNo}/price")
    public Long updateProductPrice(@RequestBody @Valid List<ProductPriceDTO.Request> productPriceRequestDtoList, @PathVariable Long productNo) {
        return productService.updateProductPrice(productPriceRequestDtoList, productNo);
    }
}
