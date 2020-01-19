package com.example.demoSpringSolr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductDTO {

    String productId;
    String name;
    String description;
    Map<String,String> productAttributes;
    int productRating;
    int noOfSoldUnits;
    String imageUrl;


}
