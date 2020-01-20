package com.example.demoSpringSolr.controller;


import com.example.demoSpringSolr.dto.SearchProductDTO;
import com.example.demoSpringSolr.entity.SearchProduct;
import com.example.demoSpringSolr.service.SearchProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchProductController {

    @Autowired
    private SearchProductService searchProductService;


    //searchProducts.add(new SearchProduct(1,"Ball","Red color ball",map,30,4,3,"ishit"));

    //kafka give all the jsons of 3 products have been added to search also...
    @PostMapping(path ="/addOrUpdate",produces = {"application/json"})
    public ResponseEntity<SearchProduct> addSearchProduct(@RequestBody SearchProductDTO searchProductDTO){

        SearchProduct searchProduct = new SearchProduct();
        BeanUtils.copyProperties(searchProductDTO,searchProduct);
        List<String> productAttirbutes = searchProductDTO.getProductAttributes().entrySet().stream().map(entry -> entry.getKey() + "#" + entry.getValue()).collect(Collectors.toList());
        searchProduct.setProductAttributes(productAttirbutes);
        SearchProduct searchProductCreated = searchProductService.saveAll(searchProduct);
        return new ResponseEntity<>(searchProductCreated,HttpStatus.CREATED);

    }

    /*//it will give the list of JSON objects
    @GetMapping(path ="/getAll",produces = {"application/json"})
    public  Iterable<SearchProduct> getAllsearchProducts() {
        Iterable<SearchProduct> searchProductList  = searchProductService.getAllsearchProducts();
       return  searchProductList;
    }*/

    @GetMapping(path ="/{data}",produces = {"application/json"})
    public ResponseEntity<List<SearchProduct>> getAllSearchproduct(@PathVariable("data") String data) {
        List<SearchProduct> searchProductList = searchProductService.getAllsearchProducts(data);
        return new ResponseEntity<List<SearchProduct>>( searchProductList, HttpStatus.OK);
    }

}
