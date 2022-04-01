package com.hendro.alterra.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Model to create a new Product")
public class ProductDto {

    @ApiModelProperty(notes = "Primary key auto generated", example = "1")
    private Long id;

    @ApiModelProperty(notes = "Type of product", example = "Product")
    private String product;

    @ApiModelProperty(notes = "Name of product", example = "Name")
    private String name;

    @ApiModelProperty(notes = "Desc of product", example = "Desc product")
    private String description;

    @ApiModelProperty(notes = "Stock of product", example = "99")
    private Integer stock;

    @ApiModelProperty(notes = "price of product", example = "7000")
    private BigInteger price;
}
