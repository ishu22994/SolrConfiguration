package com.example.demoSpringSolr.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "searchProduct")
public class SearchProduct {

    @Id
    @Field
    String productId;
    @Field
    String name;
    @Field
    String description;
    @Field
    List<String> productAttributes;
    @Field
    int productRating;
    @Field
    int noOfSoldUnits;
    @Field
    String imageUrl;

}
