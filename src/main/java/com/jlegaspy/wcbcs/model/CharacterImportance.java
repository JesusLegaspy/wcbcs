package com.jlegaspy.wcbcs.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class CharacterImportance {
  private Long characterId;
  private Integer importance;

  public CharacterImportance() {
  }

  public CharacterImportance(Long characterId, Integer importance) {
    this.characterId = characterId;
    this.importance = importance;
  }

  public Long getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Long characterId) {
    this.characterId = characterId;
  }

  public Integer getImportance() {
    return importance;
  }

  public void setImportance(Integer importance) {
    this.importance = importance;
  }
}
