package com.miriamabalo.assignment.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miriamabalo.assignment.model.Prices;
import com.miriamabalo.assignment.model.response.PriceResponse;
import com.miriamabalo.assignment.persistence.PricesRepository;

@Service
public class PricesService {

	@Autowired
	private PricesRepository repository;

	public PriceResponse findOne(Date applicationDate, Long productId, Long brandId) {

		PriceResponse response = new PriceResponse();

		Prices prices = repository.findOne(applicationDate, productId, brandId);

		if (prices != null) {
			response.copy(prices.getProductId(), prices.getBrand().getName(), prices.getPriceList(),
					prices.getStartDate(), prices.getEndDate(), prices.getPrice());
		}

		return response;
	}

}
