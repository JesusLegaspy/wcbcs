package com.jlegaspy.wcbcs.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
  private @Id @GeneratedValue Long id;
  private String title;
  private Long arkId;
  private Integer series;
  private String image;
  private List<Long> chapterIds;

  public Book() {
  }

  public Book(String title, Long arkId, Integer series, String image, List<Long> chapterIds) {
    this.title = title;
    this.arkId = arkId;
    this.series = series;
    this.image = image;
    this.chapterIds = chapterIds;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getArkId() {
    return arkId;
  }

  public void setArkId(Long arkId) {
    this.arkId = arkId;
  }

  public Integer getSeries() {
    return series;
  }

  public void setSeries(Integer series) {
    this.series = series;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<Long> getChapterIds() {
    return chapterIds;
  }

  public void setChapterIds(List<Long> chapterIds) {
    this.chapterIds = chapterIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return Objects.equals(this.id, book.id) && Objects.equals(this.title, book.title)
        && Objects.equals(this.arkId, book.arkId) && Objects.equals(this.series, book.series)
        && Objects.equals(this.image, book.image) && Objects.equals(this.chapterIds, book.chapterIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.title, this.arkId, this.series, this.image, this.chapterIds);
  }

  @Override
  public String toString() {
    return String.format("Book{id=%d, title=%s, arkId=%d, series=%d, image=%s, chapterIds=%s}", this.id, this.title,
        this.arkId, this.series, this.image, this.chapterIds);
  }
}
