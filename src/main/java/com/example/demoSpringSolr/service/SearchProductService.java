package com.example.demoSpringSolr.service;

import com.example.demoSpringSolr.entity.SearchProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SearchProductService {

    //
    List<SearchProduct> getAllsearchProducts(String data);

    SearchProduct saveAll(SearchProduct searchProduct);
}
