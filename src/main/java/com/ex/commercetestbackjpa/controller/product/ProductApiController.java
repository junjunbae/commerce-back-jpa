package com.ex.commercetestbackjpa.controller.product;

import com.ex.commercetestbackjpa.domain.dto.product.ProductRequestDto;
import com.ex.commercetestbackjpa.domain.dto.product.ProductResponseDto;
import com.ex.commercetestbackjpa.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("")
    public Long saveProduct (@RequestBody @Valid ProductRequestDto productRequestDto) {
        return productService.saveProduct(productRequestDto);
    }

    @GetMapping("/{productNo}")
    public ProductResponseDto findProductByProduct (@PathVariable Long productNo) {
        return productService.findProductByProductNo(productNo);
    }

    @GetMapping("")
    public HashMap<String, Object> findProductAll () {
        return productService.findProductAll();
    }
}