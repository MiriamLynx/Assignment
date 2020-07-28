package com.miriamabalo.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.miriamabalo.assignment.model.Prices;
import com.miriamabalo.assignment.persistence.PricesRepository;

@SpringBootTest
public class PricesRepositoryIntegrationTests {

	@Autowired
	private PricesRepository repository;

	@Test
	public void test1() {

		Date date = new Date(1592121600000l); // 14-06-2020 10:00:00

		Prices found = repository.findOne(date, 35455l, 1l);

		assertEquals("Zara", found.getBrand().getName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test2() {

		Date date = new Date(1592143200000l); // 14-06-2020 16:00:00

		Prices found = repository.findOne(date, 35455l, 1l);

		assertEquals("Zara", found.getBrand().getName());
		assertEquals(35455, found.getProductId());
		assertEquals(2, found.getPriceList());
		assertEquals(25.45, found.getPrice());

	}

	@Test
	public void test3() {

		Date date = new Date(1592161200000l); // 14-06-2020 21:00:00

		Prices found = repository.findOne(date, 35455l, 1l);

		assertEquals("Zara", found.getBrand().getName());
		assertEquals(35455, found.getProductId());
		assertEquals(1, found.getPriceList());
		assertEquals(35.50, found.getPrice());

	}

	@Test
	public void test4() {

		Date date = new Date(1592208000000l); // 15-06-2020 10:00:00

		Prices found = repository.findOne(date, 35455l, 1l);

		assertEquals("Zara", found.getBrand().getName());
		assertEquals(35455, found.getProductId());
		assertEquals(3, found.getPriceList());
		assertEquals(30.50, found.getPrice());

	}

	@Test
	public void test5() {

		Date date = new Date(1592334000000l); // 16-06-2020 21:00:00

		Prices found = repository.findOne(date, 35455l, 1l);

		assertEquals("Zara", found.getBrand().getName());
		assertEquals(35455, found.getProductId());
		assertEquals(4, found.getPriceList());
		assertEquals(38.95, found.getPrice());

	}

}
