package com.example.demoSpringSolr.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "employee")
public class Employee {

    @Id
    @Field
    private int id;
    @Field
    private String name;
    @Field
    private String[] address;

//    @Field
//    private String description;


}
