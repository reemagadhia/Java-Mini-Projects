package com.tatva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="productspecifications")
public class ProductSpecification {
	@Id
	@Column(name="pSpefId")
	@GeneratedValue
	private int pSpefId;
	@Column(name="type")
	private String type;
	@Column(name="description")
	private String description;
	@ManyToOne
	@JoinColumn(name="pid")
	private Product product;
	public int getpSpefId() {
		return pSpefId;
	}
	public void setpSpefId(int pSpefId) {
		this.pSpefId = pSpefId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
