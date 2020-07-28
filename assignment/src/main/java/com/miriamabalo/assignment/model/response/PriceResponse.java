package com.miriamabalo.assignment.model.response;

import java.io.Serializable;
import java.util.Date;

public class PriceResponse implements Serializable {

	private static final long serialVersionUID = 8391951198500115379L;

	private Long productId;
	private String brandName;
	private Long priceList;
	private Date startDate;
	private Date endDate;
	private Double price;

	public void copy(Long productId, String brandName, Long priceList, Date startDate, Date endDate, Double price) {
		this.productId = productId;
		this.brandName = brandName;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
