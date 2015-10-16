package com.ciandt.techgallery.service.transformer;

import com.google.api.server.spi.config.Transformer;

import com.ciandt.techgallery.persistence.model.TechGalleryUser;
import com.ciandt.techgallery.service.model.UserResponse;

public class TechGalleryUserTransformer implements Transformer<TechGalleryUser, UserResponse> {

  @Override
  public TechGalleryUser transformFrom(UserResponse arg0) {
    TechGalleryUser product = new TechGalleryUser();
    product.setEmail(arg0.getEmail());
    product.setGoogleId(arg0.getGoogleId());
    product.setId(arg0.getId());
    product.setName(arg0.getName());
    product.setPhoto(arg0.getPhoto());
    return product;
  }

  @Override
  public UserResponse transformTo(TechGalleryUser arg0) {
    if (arg0.getInactivatedDate() == null) {
      UserResponse product = new UserResponse();
      product.setEmail(arg0.getEmail());
      product.setGoogleId(arg0.getGoogleId());
      product.setId(arg0.getId());
      product.setName(arg0.getName());
      product.setPhoto(arg0.getPhoto());
      return product;
    } else {
      return null;
    }
  }

}