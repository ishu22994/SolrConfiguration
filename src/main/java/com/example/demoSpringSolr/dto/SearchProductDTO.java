package com.example.demoSpringSolr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchProductDTO {

    String productId;
    String name;
    String description;
    Map<String,String> productAttributes;
  //  List<String> productAttr
    int productRating;
    int noOfSoldUnits;
    String imageUrl;


}
