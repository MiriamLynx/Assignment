package com.miriamabalo.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.miriamabalo.assignment.model.Brand;
import com.miriamabalo.assignment.model.Prices;
import com.miriamabalo.assignment.model.response.PriceResponse;
import com.miriamabalo.assignment.persistence.PricesRepository;
import com.miriamabalo.assignment.service.PricesService;

@RunWith(MockitoJUnitRunner.class)
public class PricesServiceIntegrationTests {

	@InjectMocks
	private PricesService service;

	@Mock
	private PricesRepository repository;

	Date date1 = new Date(1592121600000l); // 14-06-2020 10:00:00
	Date date2 = new Date(1592143200000l); // 14-06-2020 16:00:00
	Date date3 = new Date(1592161200000l); // 14-06-2020 21:00:00
	Date date4 = new Date(1592208000000l); // 15-06-2020 10:00:00
	Date date5 = new Date(1592334000000l); // 16-06-2020 21:00:00

	Long productId = 35455l;
	Long brandId = 1l;

	@Before()
	public void setUp() {

		Brand brand = new Brand();
		brand.setId(1l);
		brand.setName("Zara");

		Prices pricesTest1 = new Prices();
		pricesTest1.setBrand(brand);
		pricesTest1.setProductId(35455l);
		pricesTest1.setPriceList(1l);
		pricesTest1.setPrice(35.50);

		Mockito.when(repository.findOne(date1, productId, brandId)).thenReturn(pricesTest1);

		Prices pricesTest2 = new Prices();
		pricesTest2.setBrand(brand);
		pricesTest2.setProductId(35455l);
		pricesTest2.setPriceList(2l);
		pricesTest2.setPrice(25.45);

		Mockito.when(repository.findOne(date2, productId, brandId)).thenReturn(pricesTest2);

		Prices pricesTest3 = new Prices();
		pricesTest3.setBrand(brand);
		pricesTest3.setProductId(35455l);
		pricesTest3.setPriceList(1l);
		pricesTest3.setPrice(35.50);

		Mockito.when(repository.findOne(date3, productId, brandId)).thenReturn(pricesTest3);

		Prices pricesTest4 = new Prices();
		pricesTest4.setBrand(brand);
		pricesTest4.setProductId(35455l);
		pricesTest4.setPriceList(3l);
		pricesTest4.setPrice(30.50);

		Mockito.when(repository.findOne(date4, productId, brandId)).thenReturn(pricesTest4);

		Prices pricesTest5 = new Prices();
		pricesTest5.setBrand(brand);
		pricesTest5.setProductId(35455l);
		pricesTest5.setPriceList(4l);
		pricesTest5.setPrice(38.95);

		Mockito.when(repository.findOne(date5, productId, brandId)).thenReturn(pricesTest5);

	}

	@Test
	public void test1() {

		PriceResponse found = service.findOne(date1, productId, brandId);

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test2() {

		PriceResponse found = service.findOne(date2, productId, brandId);

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(2, found.getPriceList());
		assertEquals(25.45, found.getPrice());

	}

	@Test
	public void test3() {

		PriceResponse found = service.findOne(date3, productId, brandId);

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test4() {

		PriceResponse found = service.findOne(date4, productId, brandId);

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(3, found.getPriceList());
		assertEquals(30.50, found.getPrice());

	}

	@Test
	public void test5() {

		PriceResponse found = service.findOne(date5, productId, brandId);

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(4, found.getPriceList());
		assertEquals(38.95, found.getPrice());

	}

}
