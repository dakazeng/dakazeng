package com.ldq.emu;

import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmuApplicationTests {

	@Test 
	public void testMd5() throws NoSuchAlgorithmException{ 
		
		System.out.println(DigestUtils.md5DigestAsHex("1234".getBytes())); 
		// 81dc9bdb52d04dc20036dbd8313ed055 }
	}
	
	
}
