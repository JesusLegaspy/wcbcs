package com.jlegaspy.wcbcs.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Chapter {
  private @Id @GeneratedValue Long id;
  private Integer chapterNumber;

  @ElementCollection
  private List<CharacterImportance> characterImportances;

  public Chapter() {
  }

  public Chapter(Integer chapterNumber, List<CharacterImportance> characterImportances) {
    this.chapterNumber = chapterNumber;
    this.characterImportances = characterImportances;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getChapterNumber() {
    return chapterNumber;
  }

  public void setChapterNumber(Integer chapterNumber) {
    this.chapterNumber = chapterNumber;
  }

  public List<CharacterImportance> getCharacterImportances() {
    return characterImportances;
  }

  public void setCharacterImportances(List<CharacterImportance> characterImportances) {
    this.characterImportances = characterImportances;
  }
}
