package com.ciandt.techgallery.service.util;

import com.google.api.server.spi.config.Transformer;

import com.ciandt.techgallery.persistence.model.Technology;
import com.ciandt.techgallery.service.model.TechnologyResponse;

public class TechnologyTransformer implements Transformer<Technology, TechnologyResponse> {

  @Override
  public Technology transformFrom(TechnologyResponse arg0) {
    Technology product = new Technology();
    product.setAuthor(arg0.getAuthor());
    product.setDescription(arg0.getDescription());
    product.setId(arg0.getId());
    product.setImage(arg0.getImage());
    product.setName(arg0.getName());
    product.setRecommendation(arg0.getRecommendation());
    product.setShortDescription(arg0.getShortDescription());
    product.setWebsite(arg0.getWebsite());
    return product;
  }

  @Override
  public TechnologyResponse transformTo(Technology arg0) {
    if (arg0.getInactivatedDate() == null) {
      TechnologyResponse product = new TechnologyResponse();
      product.setAuthor(arg0.getAuthor());
      product.setDescription(arg0.getDescription());
      product.setId(arg0.getId());
      product.setImage(arg0.getImage());
      product.setName(arg0.getName());
      product.setRecommendation(arg0.getRecommendation());
      product.setShortDescription(arg0.getShortDescription());
      product.setWebsite(arg0.getWebsite());
      return product;
    } else {
      return null;
    }
  }

}