package com.example.demoSpringSolr.repository;

import com.example.demoSpringSolr.entity.SearchProduct;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchProductRepository extends SolrCrudRepository<SearchProduct,Integer> {



}
