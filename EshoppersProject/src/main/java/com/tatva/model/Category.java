package com.tatva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@Column(name="cid")
	@GeneratedValue
	private int cid;
	@Column(name="category")
	private String category;
	@Column(name="parentCategory")
	private String parentCategory;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int cid) {
		super();
		this.cid = cid;
	}
	public Category(String category, String parentCategory) {
		super();
		this.category = category;
		this.parentCategory = parentCategory;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(String parentCategory) {
		this.parentCategory = parentCategory;
	}
}
