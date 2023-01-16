package com.sm.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sm.entity.Product;
import com.sm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/{id}")

    public MappingJacksonValue findProductById(@PathVariable Long id) {
        Product product = service.getProductById(id);
        if (product == null) return null;

        Set<String> fields = new HashSet<>();
        fields.add("id");
        fields.add("name");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("productFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));
        MappingJacksonValue mapper = new MappingJacksonValue(product);
        mapper.setFilters(filterProvider);
        return mapper;
    }
}
