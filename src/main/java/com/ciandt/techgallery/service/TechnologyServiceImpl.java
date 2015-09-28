package com.ciandt.techgallery.service;

import com.google.api.server.spi.response.BadRequestException;
import com.google.api.server.spi.response.InternalServerErrorException;
import com.google.api.server.spi.response.NotFoundException;

import com.ciandt.techgallery.persistence.dao.TechnologyDAO;
import com.ciandt.techgallery.persistence.dao.TechnologyDAOImpl;
import com.ciandt.techgallery.persistence.model.Technology;
import com.ciandt.techgallery.service.enums.TechnologyOrderOptionEnum;
import com.ciandt.techgallery.service.enums.ValidationMessageEnums;
import com.ciandt.techgallery.service.model.Response;
import com.ciandt.techgallery.service.model.TechnologiesResponse;
import com.ciandt.techgallery.service.model.TechnologyResponse;
import com.ciandt.techgallery.utils.i18n.I18n;

import java.util.ArrayList;
import java.util.List;

/**
 * Services for Technology Endpoint requests.
 * 
 * @author felipers
 *
 */
public class TechnologyServiceImpl implements TechnologyService {

  private static final I18n i18n = I18n.getInstance();
  TechnologyDAO technologyDAO = new TechnologyDAOImpl();

  /**
   * POST for adding a technology.
   */
  @Override
  public Response addTechnology(final TechnologyResponse technology)
      throws InternalServerErrorException, BadRequestException {
    String techId = technology.getId();
    String techName = technology.getName();

    // technology id can't be null or empty
    if (techId == null || techId.equals("")) {
      throw new BadRequestException(i18n.t("Technology's id cannot be blank."));
    }
    // technology name can't be null or empty
    if (techName == null || techName.equals("")) {
      throw new BadRequestException(i18n.t("Technology's name cannot be blank."));
    } else {
      Technology entity = new Technology();
      entity.setId(techId);
      entity.setName(techName);
      entity.setShortDescription(technology.getShortDescription());
      entity.setDescription(technology.getDescription());
      entity.setAuthor(technology.getAuthor());
      entity.setWebsite(technology.getWebsite());
      entity.setImage(technology.getImage());
      entity.setRecommendation(technology.getRecommendation());
      technologyDAO.add(entity);
      // set the id and return it
      technology.setId(entity.getId());
      return technology;
    }
  }

  /**
   * GET for getting all technologies.
   */
  @Override
  public Response getTechnologies() throws InternalServerErrorException, NotFoundException {
    List<Technology> techEntities = technologyDAO.findAll();
    // if list is null, return a not found exception
    if (techEntities == null) {
      throw new NotFoundException(i18n.t("No technology was found."));
    } else {
      TechnologyOrderOptionEnum orderBy = TechnologyOrderOptionEnum.COMENTARY_QUANTITY;
      sortTechnologies(techEntities, orderBy);

      TechnologiesResponse response = new TechnologiesResponse();
      List<TechnologyResponse> internList = new ArrayList<TechnologyResponse>();
      for (int i = 0; i < techEntities.size(); i++) {
        Technology tech = techEntities.get(i);
        TechnologyResponse techResponseItem = new TechnologyResponse();
        techResponseItem.setId(tech.getId());
        techResponseItem.setName(tech.getName());
        techResponseItem.setShortDescription(tech.getShortDescription());
        techResponseItem.setAuthor(tech.getAuthor());
        techResponseItem.setDescription(tech.getDescription());
        techResponseItem.setImage(tech.getImage());
        techResponseItem.setWebsite(tech.getWebsite());
        techResponseItem.setRecommendation(tech.getRecommendation());
        internList.add(techResponseItem);
      }
      response.setTechnologies(internList);
      return response;
    }
  }

  private void sortTechnologies(List<Technology> techEntities, TechnologyOrderOptionEnum orderBy) {
    switch (orderBy) {
      case POSITIVE_RECOMENDATION_QUANTITY:

        break;
      case NEGATIVE_RECOMENDATION_QUANTITY:

        break;
      case COMENTARY_QUANTITY:

        break;
      case ENDORSEMENT_QUANTITY:

        break;
      default:
        break;
    }
  }

  /**
   * GET for getting one technology.
   */
  @Override
  public Response getTechnology(final String id) throws NotFoundException {
    Technology techEntity = technologyDAO.findById(id);
    // if technology is null, return a not found exception
    if (techEntity == null) {
      throw new NotFoundException(i18n.t("No technology was found."));
    } else {
      TechnologyResponse response = new TechnologyResponse();
      response.setId(techEntity.getId());
      response.setName(techEntity.getName());
      response.setShortDescription(techEntity.getShortDescription());
      response.setAuthor(techEntity.getAuthor());
      response.setDescription(techEntity.getDescription());
      response.setImage(techEntity.getImage());
      response.setWebsite(techEntity.getWebsite());
      response.setRecommendation(techEntity.getRecommendation());
      return response;
    }
  }

  @Override
  public Technology getTechnologyById(String id) throws NotFoundException {
    Technology tech = technologyDAO.findById(id);
    if (tech == null) {
      throw new NotFoundException(ValidationMessageEnums.TECHNOLOGY_NOT_EXIST.message());
    } else {
      return tech;
    }
  }
}
