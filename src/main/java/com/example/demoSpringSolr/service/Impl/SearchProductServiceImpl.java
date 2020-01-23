package com.example.demoSpringSolr.service.Impl;

import com.example.demoSpringSolr.entity.SearchProduct;
import com.example.demoSpringSolr.repository.SearchProductRepository;
import com.example.demoSpringSolr.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchProductServiceImpl implements SearchProductService {

    @Autowired
    SearchProductRepository searchProductRepository;

    //
    @Override
    public List<SearchProduct> getAllsearchProducts(String data) {
        return searchProductRepository.findByString(data);
    }

    @Override
    public SearchProduct saveAll(SearchProduct searchProduct) {
        return searchProductRepository.save(searchProduct);
    }
}
