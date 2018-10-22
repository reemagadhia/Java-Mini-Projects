package com.tatva.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue
	private int pid;
	@Column(name="name")
	private String name;
	@Column(name="code")
	private String code;
	@Column(name="description")
	private String description;
	@Column(name="review")
	private String review;
	@Column(name="returnPolicy")
	private String returnPolicy;
	@Column(name="stockLimit")
	private String stockLimit;
	@Column(name="maxLimit")
	private String maxLimit;
	@Column(name="tandc")
	private String tandc;
	@Column(name="offerStartDate")
	private Date offerStartDate;
	@Column(name="offerEndDate")
	private Date offerEndDate;
	
	
	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL)
	private List<ProductImages> productImg = new ArrayList<ProductImages>();
	
	@OneToMany(mappedBy = "product", cascade=CascadeType.ALL)
	private List<ProductSpecification> productSpef = new ArrayList<ProductSpecification>();
	
	@ManyToOne
	@JoinColumn(name="uid", unique=true)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cid", unique=true)
	private Category category;

	
	public Product() {
		super();
	}
	public Product(int pid) {
		super();
		this.pid = pid;
	}
	
	public Product(String name, String code, String description, String review, String returnPolicy, String stockLimit,
			String maxLimit, String tandc, User user, Category category) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.review = review;
		this.returnPolicy = returnPolicy;
		this.stockLimit = stockLimit;
		this.maxLimit = maxLimit;
		this.tandc = tandc;
		this.user = user;
		this.category = category;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getReturnPolicy() {
		return returnPolicy;
	}

	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	public String getStockLimit() {
		return stockLimit;
	}

	public void setStockLimit(String stockLimit) {
		this.stockLimit = stockLimit;
	}

	public String getMaxLimit() {
		return maxLimit;
	}

	public void setMaxLimit(String maxLimit) {
		this.maxLimit = maxLimit;
	}

	public String getTandc() {
		return tandc;
	}

	public void setTandc(String tandc) {
		this.tandc = tandc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductImages> getProductImg() {
		return productImg;
	}

	public void setProductImg(List<ProductImages> productImg) {
		this.productImg = productImg;
	}

	public List<ProductSpecification> getProductSpef() {
		return productSpef;
	}

	public void setProductSpef(List<ProductSpecification> productSpef) {
		this.productSpef = productSpef;
	}
	
	public Date getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public Date getOfferEndDate() {
		return offerEndDate;
	}

	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
	}
	
	
}
