package com.colak.springannotationstutorial.numberformat.dto;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

/**
 * This DTO is used as a parameter to @GetMapping request. It uses Spring binding to format a number
 */
public record ProductDto(@NumberFormat(pattern = "#,###.00") BigDecimal price) {
}
