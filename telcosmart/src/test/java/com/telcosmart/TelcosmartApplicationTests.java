package com.telcosmart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.TestSuite;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TelcosmartApplicationTests {
	
	@InjectMocks
	TelcosmartApplication telcosmartApplication;
	
	/*@Test
	public void mainTest() {
		String[] args = new String[] {"test","test1"};
		
				
		telcosmartApplication.main(args);
	}*/

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void suite() {
		new TestSuite(TelcosmartApplicationTests.class);
		
	}

}
