package com.tatva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="productimages")
public class ProductImages {
	@Id
	@Column(name="pImgId")
	@GeneratedValue
	private int pImgId;
	@Column(name="url")
	private String url;
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;
	
	public int getpImgId() {
		return pImgId;
	}
	public void setpImgId(int pImgId) {
		this.pImgId = pImgId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
