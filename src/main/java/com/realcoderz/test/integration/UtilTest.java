package com.realcoderz.test.integration;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.realcoderz.util.DateCalculation;
@ContextConfiguration(locations="classpath:com/realcoderz/resources/cst-root-ctx.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Rollback(true)
@Transactional
public class UtilTest {

	@Test
	public void differenceDateTes()
	{
		Date date = new Date("10/05/1994");
		long age = DateCalculation.getAge(date);
		

		
		assertTrue(age > 0);
	}
}
