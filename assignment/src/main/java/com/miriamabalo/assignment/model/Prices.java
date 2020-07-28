package com.miriamabalo.assignment.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prices")
@NamedEntityGraph(name = "Prices.brand", attributeNodes = { @NamedAttributeNode(value = "brand") })
public class Prices implements Serializable {

	private static final long serialVersionUID = -8167709209384134879L;

	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Brand brand;

	@Column(name = "price_list")
	private Long priceList;

	private String curr;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "product_id")
	private Long productId;

	private Integer priority;

	@Column(name = "end_date")
	private Date endDate;

	private Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
