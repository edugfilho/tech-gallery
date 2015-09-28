package com.ciandt.techgallery.persistence.model.counter;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

import com.ciandt.techgallery.persistence.model.BaseEntity;
import com.ciandt.techgallery.persistence.model.Technology;

import java.util.Set;

/**
 * Entity for TechnologyDetailsCounter.
 * 
 * @author ibrahim
 *
 */
@Entity
public class TechnologyDetailsCounter extends BaseEntity<Long> {

  @Id
  private Long id;

  @Index
  @Load
  private Ref<Technology> technology;

  @Index
  private Integer positiveRecomendationsCounter = 0;

  @Index
  private Integer negativeRecomendationsCounter = 0;

  @Index
  private Integer commentariesCounter = 0;

  @Index
  private Set<Long> endorsedSet;

  /**
   * Add 1 to the positive recomndations counter.
   */
  public void addPositiveRecomendationsCounter() {
    this.positiveRecomendationsCounter++;
  }

  /**
   * Remove 1 to the positive recomndations counter.
   */
  public void removePositiveRecomendationsCounter() {
    if (this.positiveRecomendationsCounter > 0) {
      this.positiveRecomendationsCounter--;
    } else {
      this.positiveRecomendationsCounter = 0;
    }
  }

  /**
   * Add 1 to the negative recomndations counter.
   */
  public void addNegativeRecomendationsCounter() {
    this.negativeRecomendationsCounter++;
  }

  /**
   * Remove 1 to the negative recomndations counter.
   */
  public void removeNegativeRecomendationsCounter() {
    if (this.negativeRecomendationsCounter > 0) {
      this.negativeRecomendationsCounter--;
    } else {
      this.negativeRecomendationsCounter = 0;
    }
  }

  /**
   * Add 1 to the commentary counter.
   */
  public void addCommentariesCounter() {
    this.commentariesCounter++;
  }

  /**
   * Remove 1 to the commentary counter.
   */
  public void removeCommentariesCounter() {
    if (this.commentariesCounter > 0) {
      this.commentariesCounter--;
    } else {
      this.commentariesCounter = 0;
    }
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Set<Long> getEndorsedSet() {
    return endorsedSet;
  }

  public void setEndorsedSet(Set<Long> endorsedSet) {
    this.endorsedSet = endorsedSet;
  }

  public Ref<Technology> getTechnology() {
    return technology;
  }

  public void setTechnology(Ref<Technology> technology) {
    this.technology = technology;
  }

  public Integer getPositiveRecomendationsCounter() {
    return positiveRecomendationsCounter;
  }

  public void setPositiveRecomendationsCounter(Integer positiveRecomendationsCounter) {
    this.positiveRecomendationsCounter = positiveRecomendationsCounter;
  }

  public Integer getNegativeRecomendationsCounter() {
    return negativeRecomendationsCounter;
  }

  public void setNegativeRecomendationsCounter(Integer negativeRecomendationsCounter) {
    this.negativeRecomendationsCounter = negativeRecomendationsCounter;
  }

  public Integer getCommentariesCounter() {
    return commentariesCounter;
  }

  public void setCommentariesCounter(Integer commentariesCounter) {
    this.commentariesCounter = commentariesCounter;
  }
}
