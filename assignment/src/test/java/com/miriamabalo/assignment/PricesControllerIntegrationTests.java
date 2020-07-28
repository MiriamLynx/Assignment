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
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.miriamabalo.assignment.controller.PriceController;
import com.miriamabalo.assignment.model.response.PriceResponse;
import com.miriamabalo.assignment.service.PricesService;

@RunWith(MockitoJUnitRunner.class)
public class PricesControllerIntegrationTests {

	@InjectMocks
	private PriceController controller;

	@Mock
	private PricesService service;

	Date date1 = new Date(1592121600000l); // 14-06-2020 10:00:00
	Date date2 = new Date(1592143200000l); // 14-06-2020 16:00:00
	Date date3 = new Date(1592161200000l); // 14-06-2020 21:00:00
	Date date4 = new Date(1592208000000l); // 15-06-2020 10:00:00
	Date date5 = new Date(1592334000000l); // 16-06-2020 21:00:00

	Long productId = 35455l;
	Long brandId = 1l;

	@Before()
	public void setUp() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		PriceResponse pricesTest1 = new PriceResponse();
		pricesTest1.setBrandName("Zara");
		pricesTest1.setProductId(35455l);
		pricesTest1.setPriceList(1l);
		pricesTest1.setPrice(35.50);

		Mockito.when(service.findOne(date1, productId, brandId)).thenReturn(pricesTest1);

		PriceResponse pricesTest2 = new PriceResponse();
		pricesTest2.setBrandName("Zara");
		pricesTest2.setProductId(35455l);
		pricesTest2.setPriceList(2l);
		pricesTest2.setPrice(25.45);

		Mockito.when(service.findOne(date2, productId, brandId)).thenReturn(pricesTest2);
		
		PriceResponse pricesTest3 = new PriceResponse();
		pricesTest3.setBrandName("Zara");
		pricesTest3.setProductId(35455l);
		pricesTest3.setPriceList(1l);
		pricesTest3.setPrice(35.50);
		
		Mockito.when(service.findOne(date3, productId, brandId)).thenReturn(pricesTest3);
		
		PriceResponse pricesTest4 = new PriceResponse();
		pricesTest4.setBrandName("Zara");
		pricesTest4.setProductId(35455l);
		pricesTest4.setPriceList(3l);
		pricesTest4.setPrice(30.50);
		
		Mockito.when(service.findOne(date4, productId, brandId)).thenReturn(pricesTest4);
		
		PriceResponse pricesTest5 = new PriceResponse();
		pricesTest5.setBrandName("Zara");
		pricesTest5.setProductId(35455l);
		pricesTest5.setPriceList(4l);
		pricesTest5.setPrice(38.95);
		
		Mockito.when(service.findOne(date5, productId, brandId)).thenReturn(pricesTest5);
	}

	@Test
	public void test1() {

		ResponseEntity<PriceResponse> responseEntity = controller.findOne(date1, productId, brandId);
		PriceResponse found = responseEntity.getBody();

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test2() {

		ResponseEntity<PriceResponse> responseEntity = controller.findOne(date2, productId, brandId);
		PriceResponse found = responseEntity.getBody();

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(2, found.getPriceList());
		assertEquals(25.45, found.getPrice());

	}

	@Test
	public void test3() {

		ResponseEntity<PriceResponse> responseEntity = controller.findOne(date3, productId, brandId);
		PriceResponse found = responseEntity.getBody();

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test4() {

		ResponseEntity<PriceResponse> responseEntity = controller.findOne(date4, productId, brandId);
		PriceResponse found = responseEntity.getBody();

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(3, found.getPriceList());
		assertEquals(30.50, found.getPrice());

	}

	@Test
	public void test5() {

		ResponseEntity<PriceResponse> responseEntity = controller.findOne(date5, productId, brandId);
		PriceResponse found = responseEntity.getBody();

		assertEquals("Zara", found.getBrandName());
		assertEquals(35455, found.getProductId());
		assertEquals(4, found.getPriceList());
		assertEquals(38.95, found.getPrice());

	}

}
