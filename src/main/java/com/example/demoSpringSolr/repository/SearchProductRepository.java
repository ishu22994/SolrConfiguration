package com.example.demoSpringSolr.repository;

import com.example.demoSpringSolr.entity.SearchProduct;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchProductRepository extends SolrCrudRepository<SearchProduct,Integer> {


    @Query("(name:*?0*)^5 OR (description:*?0*)^2 OR (productAttributes:*?0*)^3 ")
    List<SearchProduct> findByString(String name);
}
