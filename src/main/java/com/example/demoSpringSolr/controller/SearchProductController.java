package com.example.demoSpringSolr.controller;


import com.example.demoSpringSolr.dto.SearchProductDTO;
import com.example.demoSpringSolr.entity.SearchProduct;
import com.example.demoSpringSolr.service.SearchProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class SearchProductController {

    @Autowired
    private SearchProductService searchProductService;

    SearchProductDTO searchProductDTO=new SearchProductDTO();
     /// TO DO :PROPERTIES CHANGE IN KAFKA FOR DOCUMENT TYPE...
    @KafkaListener(topics="productUpdate",groupId="group_id")
    public void consume(String message){
        SearchProduct searchProduct=new SearchProduct();
        ObjectMapper objectMapper=new ObjectMapper();
        try{
            searchProductDTO=objectMapper.readValue(message,SearchProductDTO.class);
        }
        catch(Exception e){
            log.error("Error : ", e);
        }

        BeanUtils.copyProperties(searchProductDTO,searchProduct);
        List<String> productAttirbutes = searchProductDTO.getProductAttributes().entrySet().stream().map(entry -> entry.getKey() + "#" + entry.getValue()).collect(Collectors.toList());
        searchProduct.setProductAttributes(productAttirbutes);
        SearchProduct searchProductCreated = searchProductService.saveAll(searchProduct);
        System.out.println(searchProductCreated.getName());


    }


    @GetMapping(path ="/{data}",produces = {"application/json"})
    public ResponseEntity<List<SearchProductDTO>> getAllSearchproduct(@PathVariable("data") String data) {


        List<SearchProduct> searchProductList = searchProductService.getAllsearchProducts(data);
        List<SearchProductDTO> searchProductDTOList = new ArrayList<>();
        for (SearchProduct searchProduct: searchProductList) {
            SearchProductDTO searchProductDTO = new SearchProductDTO();
            BeanUtils.copyProperties(searchProduct, searchProductDTO);
            searchProductDTOList.add(searchProductDTO);
        }

        return new ResponseEntity<List<SearchProductDTO>>( searchProductDTOList, HttpStatus.OK);
    }




}
